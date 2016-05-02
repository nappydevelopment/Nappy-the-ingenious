package nappydevelopment.nappy_the_ingenious.util.gamemode2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javafx.scene.image.Image;
import nappydevelopment.nappy_the_ingenious.GlobalReferences;
import nappydevelopment.nappy_the_ingenious.data.*;
import nappydevelopment.nappy_the_ingenious.data.Character;
import nappydevelopment.nappy_the_ingenious.data.settings.Language;


public class Gamemode2{
	private Map<String, Question> remainingQuestions;
	private final Map<String, String> character = new HashMap<>();
	private final Language lang;
	private int questionCounter = 0;
	private boolean finished = true;

	public Gamemode2(final Language l){ this(l, false); }
	public Gamemode2(
		final Language l,
		final boolean deterministic
	){
		lang = l;
		try(Statement st = DatabaseProvider.getStatement()){
			remainingQuestions = QuestionProvider.getQuestions(lang);

			if(deterministic){
				st.execute("SELECT * FROM SIMPSONS limit 1;");
			}else{
				st.execute("SELECT * FROM SIMPSONS ORDER BY RANDOM() limit 1;");
			}
			ResultSet res = st.getResultSet();
			res.next();
			for(int i = 1; i < res.getMetaData().getColumnCount(); i++){
				character.put(res.getMetaData().getColumnName(i), res.getString(i));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		finished = false;
	}

	public int answeredQuestions(){ return questionCounter; }

	public List<String> getQuestions(){
		ArrayList<String> questions= new ArrayList<>();
		questions.addAll(remainingQuestions.keySet());
		return questions;
	}

	public Answer askQuestion(final String question) throws NoMoreQuestions, InvalidQuestion, GameHasFinished{
		if(finished){
			throw new GameHasFinished();
		}
		questionCounter++;

		Question q = remainingQuestions.get(question);
		if(remainingQuestions.values().stream().count() == 0){
			throw new NoMoreQuestions();
		}
		if(q == null){
			throw new InvalidQuestion();
		}
		boolean answer = character.get(q.getTable()).equals(q.getAttribute());

		remainingQuestions.remove(question);

		return Answer.fromBool(answer);
	}

	public Boolean makeGuess(final Character wiki){
		return makeGuess(wiki.getName());
	}
	public Boolean makeGuess(final String name){
		if(finished){
			return null;
		}
		questionCounter++;
		return character.get("NAME").equals(name);
	}

	public boolean finished(){ return finished; }

	public Character endGame(){
		if(finished){ return null; }
		finished = true;

		Map<Language, String> nicknames = new HashMap<>();
		Map<Language, String> descriptions = new HashMap<>();

		for(Language l: Language.values()){
			nicknames.put(l, character.get("NICKNAME_"+ l.getCode()));
			descriptions.put(l, character.get("DESCRIPTION_"+ l.getCode()));
		}

		Image img = null;
		try{
			img = new Image(GlobalReferences.IMAGES_PATH + "wiki/" + character.get("NAME").toLowerCase().replace(" ", "_") +".png");
		}catch(RuntimeException e){
			if(!"Internal graphics not initialized yet".equals(e.getMessage())){
				throw e;
			}
		}
		return new Character(
			character.get("NAME"),
			nicknames,
			descriptions,
			img,
			Gender.fromBool(character.get("MALE").equals("TRUE")),
			Age.fromString(character.get("AGE")));
	}
}
