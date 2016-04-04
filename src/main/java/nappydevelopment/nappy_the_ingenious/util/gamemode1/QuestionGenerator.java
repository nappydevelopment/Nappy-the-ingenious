package nappydevelopment.nappy_the_ingenious.util.gamemode1;

import javafx.scene.image.Image;
import nappydevelopment.nappy_the_ingenious.GlobalReferences;
import nappydevelopment.nappy_the_ingenious.data.DatabaseProvider;
import nappydevelopment.nappy_the_ingenious.data.WikiCharacter;
import nappydevelopment.nappy_the_ingenious.data.settings.Language;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QuestionGenerator{

	private String[] column = new String[40];
	private boolean[] columnBool = new boolean[40];
	private Boolean[] ans = new Boolean[40];
	private String[] question = new String[40];
	private boolean[] dunno = new boolean[40];
	private int numDunno = 0;
	private int activeQuestion = -1;
	private boolean determinisic = false;
	private boolean firstQuestion = true;

    public QuestionGenerator(){
		try{
        	Statement st = DatabaseProvider.getStatement();
			st.execute(
				"SELECT * FROM INFORMATION_SCHEMA.COLUMNS \n" +
				"WHERE TABLE_NAME = 'SIMPSONS'\n" +
				"AND COLUMN_NAME != 'ID'\n" +
				"AND COLUMN_NAME != 'NAME'\n" +
				"AND COLUMN_NAME != 'NICKNAME'\n" +
				"AND COLUMN_NAME NOT LIKE 'DESCRIPTION_%'"
			);
			ResultSet res = st.getResultSet();
			int i = 0;
			while(res.next()){
				column[i] = res.getString("COLUMN_NAME");
				columnBool[i] = res.getString("TYPE_NAME") == "BOOLEAN";
				ans[i] = null;
				i++;
			}
			res.close();
			st.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
    }
	public QuestionGenerator(boolean det){
		super();
		determinisic = det;
	}

	public WikiCharacter getCharacter(Language lang){
		Statement st = DatabaseProvider.getStatement();
		String select = "SELECT name, nickname, description_en, description_de FROM SIMPSONS WHERE ";
		boolean first = true;
		for(int i = 0; i < column.length; i++){
			if(column[i] != null & question[i] != null & ans[i] != null){
				if(!first){
					select += "AND ";
				}else{
					first = false;
				}
				if(ans[i]){
					select += column[i] + "='" + question[i] + "' ";
				}else{
					select += column[i] + "!='" + question[i] + "' ";
				}
			}
		}
		try{
			st.execute(select);
			ResultSet res = st.getResultSet();
			if(!res.next()){
				// not a valid character :O
				return null;
			}
			if(lang.equals(Language.GERMAN)){
				return new WikiCharacter(
					res.getString("name"),
					res.getString("nickname"),
					res.getString("description_de"),
					new Image(GlobalReferences.IMAGES_PATH + "wiki/" + res.getString("name").toLowerCase().replace(" ", "_") + ".png")
				);
			}else if(lang.equals(Language.ENGLISH)){
				return new WikiCharacter(
					res.getString("name"),
					res.getString("nickname"),
					res.getString("description_en"),
					new Image(GlobalReferences.IMAGES_PATH + "wiki/" + res.getString("name").toLowerCase().replace(" ", "_") + ".png")
				);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

    public void setAnswer(Boolean answer){
		if(activeQuestion != -1){
			if(answer == null){
				dunno[activeQuestion] = true;
				numDunno++;
			}else{
				ans[activeQuestion] = answer;
			}
			activeQuestion = -1;
			firstQuestion = false;
		}
    }

    public int getNumDunno(){
		return numDunno;
    }

	private float sureness(){
		Statement st = DatabaseProvider.getStatement();
		String select = "Select count(0) as C FROM SIMPSONS WHERE ";
		boolean first = true;
		for(int i = 0; i < column.length; i++){
			if(ans[i] == null){
				continue;
			}
			if(first){
				first = false;
			}else{
				select += "AND ";
			}

			select += column[i];
			if(!ans[i]){
				select += "!";
			}
			select += "='" + question[i] + "' ";
		}
		if(select.endsWith("WHERE ")){
			return 0;
		}
		try{
			st.execute(select);
			ResultSet res = st.getResultSet();
			res.next();
			float count = res.getFloat("C");
			if(count == 0){
				return -2;
			}
			return (1 / count);
		}catch(Throwable e){
			e.printStackTrace();
		}
		return -1;
	}

	public float getSureness(){
		float sureness = this.sureness();
		if(sureness < 0){
			return 0;
		}
		return sureness;
	}

    public Boolean isSure(){
		float sureness = this.sureness();
		if(sureness == 1){
			return true;
		}
		if(sureness < 0){
			return null;
		}
		return false;
    }

	public boolean isActive(){
		return activeQuestion != -1;
	}

    public String getQuestion(Language lang){
		if(isSure()){
			return null;
		}
		if(activeQuestion != -1){
			return giveQuestion(activeQuestion, lang);
		}
		float localMax;
		float max = 0;
		int maxNr = -1;
		for(int i = 0; i < column.length; i++){
			if(column[i] == null || ans[i] != null || dunno[i]){
				continue;
			}
			localMax = tryQuestion(i);
			if(localMax > max){
				max = localMax;
				maxNr = i;
			}
		}
		if(maxNr == -1 || max <= 0){
			return null;
		}
		activeQuestion = maxNr;
		return giveQuestion(maxNr, lang);
    }

	private String giveQuestion(int columnNr, Language lang){
		String ques = null;
		try{
			Statement st = DatabaseProvider.getStatement();
			st.execute("SELECT * from " + column[columnNr] + "_QUESTIONS WHERE ID='" + question[activeQuestion] + "'");
			ResultSet res = st.getResultSet();
			res.next();
			if(lang.equals(Language.GERMAN)){
				ques = res.getString("Q1_DE");
			}else if(lang.equals(Language.ENGLISH)){
				ques = res.getString("Q1_EN");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ques;
	}

	private float tryQuestion(int columnID){
		Statement st = DatabaseProvider.getStatement();
		String where = " WHERE ";
		if(firstQuestion == false){
			boolean first = true;
			for(int i = 0; i < column.length; i++){
				if(ans[i] != null && column[i] != null){
					if(first){
						first = false;
					}else{
						where += "AND ";
					}
					where += "SIMPSONS." + column[i];
					if(!ans[i]){
						where += " !";
					}
					where += "= '" + question[i] + "' ";
				}
			}
		}
		if(where == " WHERE "){
			where = "";
		}
		String select = "SELECT count(0) as C, " + column[columnID] + " FROM SIMPSONS" + where + " GROUP BY " + column[columnID];
		float max = 0;
		float sum = 0;
		float ret = 0;
		try{
			st.execute(select);
			ResultSet res = st.getResultSet();
			while(res.next()){
				float val = res.getInt("C");
				if(!determinisic){
					val += Math.random()*30;
				}
				if(val > max){
					max = val;
					question[columnID] = res.getString(column[columnID]);
				}
				sum += val;
			}
			ret = max / sum;
			if(ret > 0.5){
				ret = 1 - ret;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ret;
	}
}
