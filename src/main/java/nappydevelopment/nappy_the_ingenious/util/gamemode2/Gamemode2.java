package nappydevelopment.nappy_the_ingenious.util.gamemode2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.image.Image;
import nappydevelopment.nappy_the_ingenious.GlobalReferences;
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
				questionSelect += "SELECT cast(id as varchar) as ID, '"+ res.getString("COLUMN_NAME") +"' as TABL, Q1_"+ l.getCode();
				questionSelect += " FROM " + res.getString("COLUMN_NAME") + "_QUESTIONS";
			}
			res.close();

			questionSelect = "Select TABL, ID, Q1_"+ l.getCode() + " from (" + questionSelect + ")" +
							 " WHERE Q1_"+ l.getCode() +"!= 'YOU SHOULD NOT READ THIS!'";
			st.execute(questionSelect);
			res = st.getResultSet();
			while(res.next()){
				String question = res.getString("Q1_"+ l.getCode());
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

	public int answeredQuestions(){
		return questionCounter;
	}

	public String[] getQuestions() {
		Object[] questions = remainingQuestions.keySet().toArray();
		return Arrays.asList(questions).toArray(new String[questions.length]);
	}

	public Boolean askQuestion(final String question){
		if(finished){
			return null;
		}
		questionCounter++;

		Question q = remainingQuestions.get(question);
		boolean answer = character.get(q.getTable()).equals(q.getAttribute());

		remainingQuestions.remove(question);

		return answer;
	}

	public Boolean makeGuess(final WikiCharacter wiki){
		return makeGuess(wiki.getName());
	}
	public Boolean makeGuess(final String name){
		if(finished){
			return null;
		}
		if(character.get("NAME").equals(name)){
			return true;
		}
		return false;
	}

	public boolean finished() { return finished; }

	public WikiCharacter endGame(){
		if(finished){
			return null;
		}
		finished = true;
		Map<Language, String> nicknames = new HashMap<>();
		Map<Language, String> descriptions = new HashMap<>();

		for(Language l: Language.values()){
			nicknames.put(l, character.get("NICKNAME_"+ l.getCode()));
			descriptions.put(l, character.get("DESCRIPTION_"+ l.getCode()));
		}

		return new WikiCharacter(
				character.get("NAME"),
				nicknames,
				descriptions,
				new Image(GlobalReferences.IMAGES_PATH + "wiki/" + character.get("NAME").toLowerCase().replace(" ", "_") +".png")
		);
	}
}
