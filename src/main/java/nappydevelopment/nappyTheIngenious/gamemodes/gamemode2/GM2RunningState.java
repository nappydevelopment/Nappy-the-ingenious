package nappydevelopment.nappyTheIngenious.gamemodes.gamemode2;

import javafx.scene.image.Image;
import nappydevelopment.nappyTheIngenious.data.*;
import nappydevelopment.nappyTheIngenious.data.character.Character;
import nappydevelopment.nappyTheIngenious.data.character.Age;
import nappydevelopment.nappyTheIngenious.data.character.CharacterImage;
import nappydevelopment.nappyTheIngenious.data.character.Gender;
import nappydevelopment.nappyTheIngenious.data.settings.Language;
import nappydevelopment.nappyTheIngenious.exception.GameHasFinished;
import nappydevelopment.nappyTheIngenious.exception.InvalidQuestion;
import nappydevelopment.nappyTheIngenious.exception.NoMoreQuestions;
import nappydevelopment.nappyTheIngenious.gamemodes.Question;
import nappydevelopment.nappyTheIngenious.gamemodes.QuestionProvider;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GM2RunningState implements GM2State{
	private Map<String, Question> remainingQuestions;
	private final Map<String, String> character = new HashMap<>();
	private int questionCounter = 0;

	public GM2RunningState(
			final Language lang,
			final boolean deterministic
	){
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
	}

	public int answeredQuestions(){ return questionCounter; }

	public List<String> getQuestions(){
		ArrayList<String> questions= new ArrayList<>();
		questions.addAll(remainingQuestions.keySet());
		return questions;
	}

	public Answer askQuestion(final String question) throws NoMoreQuestions, InvalidQuestion, GameHasFinished{
		if(isFinished()){
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

	public Boolean makeGuess(final String name){
		if(isFinished()){
			return null;
		}
		questionCounter++;
		return character.get("NAME").equals(name);
	}

	public boolean isFinished(){ return false; }

	public Character endGame(final GameMode2 gm2){
		gm2.state = new GM2FinishedState(questionCounter);

		Map<Language, String> nicknames = new HashMap<>();
		Map<Language, String> descriptions = new HashMap<>();

		for(Language l: Language.values()){
			nicknames.put(l, character.get("NICKNAME_"+ l.getCode()));
			descriptions.put(l, character.get("DESCRIPTION_"+ l.getCode()));
		}

		Image img = new CharacterImage(character.get("NAME")).get();

		return new Character(
			character.get("NAME"),
			nicknames,
			descriptions,
			img,
			Gender.fromBool(character.get("MALE").equals("TRUE")),
			Age.fromString(character.get("AGE"))
		);
	}
}
