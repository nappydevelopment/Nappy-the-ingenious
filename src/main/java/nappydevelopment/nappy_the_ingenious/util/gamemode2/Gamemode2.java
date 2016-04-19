package nappydevelopment.nappy_the_ingenious.util.gamemode2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.image.Image;
import nappydevelopment.nappy_the_ingenious.GlobalReferences;
import nappydevelopment.nappy_the_ingenious.data.DatabaseProvider;
import nappydevelopment.nappy_the_ingenious.data.Question;
import nappydevelopment.nappy_the_ingenious.data.WikiCharacter;
import nappydevelopment.nappy_the_ingenious.data.settings.Language;


public class Gamemode2{
	private ArrayList<Question> remainingQuestions = new ArrayList<>();
	private Map<String,String> character = new HashMap<>();
	private int questionCounter = 0;
	private boolean finished = true;

	public Gamemode2(){
		this(false);
	}
	public Gamemode2(boolean deterministic){
		try(Statement st = DatabaseProvider.getStatement()){
			String questionSelect = "";
			st.execute(
				"SELECT * FROM INFORMATION_SCHEMA.COLUMNS \n" +
				"WHERE TABLE_NAME = 'SIMPSONS'\n" +
				"AND COLUMN_NAME NOT IN ('ID', 'NAME', 'NICKNAME', 'COUNTER')\n" +
				"AND COLUMN_NAME NOT LIKE 'DESCRIPTION_%'"
			);
			ResultSet res = st.getResultSet();
			String langselect = "";
			for(Language l: Language.values()){
				langselect += ", Q1_"+ l.getCode();
			}
			boolean first = true;
			while(res.next()){
				if(!first){
					questionSelect += " UNION ";
				}else{
					first = false;
				}
				questionSelect += "SELECT cast(id as varchar) as ID, '"+ res.getString("COLUMN_NAME") +"' as TABL"+ langselect;
				questionSelect += " FROM " + res.getString("COLUMN_NAME") + "_QUESTIONS";
			}
			res.close();

			questionSelect = "Select TABL, ID" + langselect + " from (" + questionSelect + ") WHERE";
			first = true;
			for(Language l: Language.values()){
				if(!first){
					questionSelect += " AND ";
				}else{
					first = false;
				}
				questionSelect += " Q1_"+ l.getCode() +"!= 'YOU SHOULD NOT READ THIS!'";
			}
			st.execute(questionSelect);
			res = st.getResultSet();
			while(res.next()){
				HashMap<Language, String> questions = new HashMap();
				for(Language l: Language.values()){
					questions.put(l, res.getString("Q1_"+ l.getCode()));
				}
				remainingQuestions.add(
					new Question(
						res.getString("TABL"),
						res.getString("ID"),
						questions
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

	public ArrayList<Question> getQuestions(){
		return remainingQuestions;
	}

	public Boolean askQuestion(Question question){
		if(finished){
			return null;
		}
		questionCounter++;
		remainingQuestions.remove(question);
		return character.get(question.getTable()).equals(question.getAttribute());
	}

	public Boolean makeGuess(WikiCharacter wiki){
		return makeGuess(wiki.getName());
	}
	public Boolean makeGuess(String name){
		if(finished){
			return null;
		}
		if(character.get("NAME").equals(name)){
			return true;
		}
		return false;
	}

	public boolean finished() { return finished; }

	public WikiCharacter endGame(Language lang){
		if(finished){
			return null;
		}
		String l = lang.getCode();
		return new WikiCharacter(
				character.get("NAME"),
				character.get("NICKNAME"),
				character.get("DESCRIPTION_" + l),
				new Image(GlobalReferences.IMAGES_PATH + "wiki/" + character.get("NAME").toLowerCase().replace(" ", "_") +".png")
		);
	}

	public static void main(String[] args) {
		Gamemode2 gm = new Gamemode2(true);
		System.out.println(gm.getQuestions().stream().count());
		Question q = gm.getQuestions().get(3);
		System.out.println(q.getQuestion(Language.GERMAN));
		System.out.println(gm.askQuestion(q));
		System.out.println(gm.getQuestions().stream().count());
		System.out.println("Jeff Albertson?");
		System.out.println(gm.makeGuess("Jeff Albertson"));
		System.out.println("Eleanor Abernathy?");
		System.out.println(gm.makeGuess("Eleanor Abernathy"));

		System.out.println("Es war: "+ gm.endGame(Language.GERMAN));
	}
}
