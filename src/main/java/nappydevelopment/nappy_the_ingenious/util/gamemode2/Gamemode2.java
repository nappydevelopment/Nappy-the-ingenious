package nappydevelopment.nappy_the_ingenious.util.gamemode2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javafx.scene.image.Image;
import nappydevelopment.nappy_the_ingenious.GlobalReferences;
import nappydevelopment.nappy_the_ingenious.data.Answer;
import nappydevelopment.nappy_the_ingenious.data.DatabaseProvider;
import nappydevelopment.nappy_the_ingenious.data.Question;
import nappydevelopment.nappy_the_ingenious.data.WikiCharacter;
import nappydevelopment.nappy_the_ingenious.data.settings.Language;


public class Gamemode2{
	private final Map<String, Question> remainingQuestions = new HashMap<>();
	private final Map<String,String> character = new HashMap<>();
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
			String questionSelect = "";
			st.execute(
				"SELECT * FROM INFORMATION_SCHEMA.COLUMNS \n" +
				"WHERE TABLE_NAME = 'SIMPSONS'\n" +
				"AND COLUMN_NAME NOT IN ('ID', 'NAME', 'COUNTER')\n" +
				"AND COLUMN_NAME NOT LIKE 'NICKNAME_%'\n" +
				"AND COLUMN_NAME NOT LIKE 'DESCRIPTION_%'"
			);
			ResultSet res = st.getResultSet();
			boolean first = true;
			while(res.next()){
				if(!first){
					questionSelect += " UNION ";
				}else{
					first = false;
				}
				questionSelect += "SELECT cast(id as varchar) as ID, '"+ res.getString("COLUMN_NAME") +"' as TABL, Q1_"+ lang.getCode();
				questionSelect += " FROM " + res.getString("COLUMN_NAME") + "_QUESTIONS";
			}
			res.close();

			questionSelect = "Select TABL, ID, Q1_"+ lang.getCode() + " from (" + questionSelect + ")" +
							 " WHERE Q1_"+ lang.getCode() +"!= 'YOU SHOULD NOT READ THIS!'";
			st.execute(questionSelect);
			res = st.getResultSet();
			while(res.next()){
				String question = res.getString("Q1_"+ lang.getCode());
				remainingQuestions.put(
					question,
					new Question(
						res.getString("TABL"),
						res.getString("ID"),
						lang,
						question
					)
				);
			}
			res.close();

			if(deterministic){
				st.execute("SELECT * FROM SIMPSONS limit 1;");
			}else{
				st.execute("SELECT * FROM SIMPSONS ORDER BY RANDOM() limit 1;");
			}
			res = st.getResultSet();
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

	public Answer askQuestion(final String question){
		//By the way to use here (return) null is not good programming you should throw an exception! 
		
		Answer ans = null;
		
		if(finished){
			return ans;
		}
		questionCounter++;

		Question q = remainingQuestions.get(question);
		if(q == null){
			return ans;
		}
		
		
		boolean answer = character.get(q.getTable()).equals(q.getAttribute());
       
		
		if(answer) {
			ans = Answer.YES;
		}
		else {
			ans = Answer.NO;
		}
		
		remainingQuestions.remove(question);

		return ans;
	}

	public Boolean makeGuess(final WikiCharacter wiki){
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

	public WikiCharacter endGame(){
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
		return new WikiCharacter(
			character.get("NAME"),
			nicknames,
			descriptions,
			img
		);
	}
}
