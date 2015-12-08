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
    private Boolean[] ans = new Boolean[40];
	private String[] question = new String[40];
	private boolean[] dunno = new boolean[40];
	private int numDunno = 0;
	private int activeQuestion = -1;

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
				ans[i] = null;
				i++;
			}
			res.close();
			st.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
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
					new Image(GlobalReferences.IMAGES_PATH + "wiki/" + res.getString("name").toLowerCase().replace(" ", "_") +".png")
				);
			}else if(lang.equals(Language.ENGLISH)){
				return new WikiCharacter(
					res.getString("name"),
					res.getString("nickname"),
					res.getString("description_en"),
					new Image(GlobalReferences.IMAGES_PATH + "wiki/" + res.getString("name").toLowerCase().replace(" ", "_") +".png")
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
		if(select.endsWith("WHERE ")){
			return 0;
		}
		try{
			st.execute(select);
			ResultSet res = st.getResultSet();
			res.next();
			float num = res.getFloat("C");
			if(num == 0){
				return -2;
			}
			return (1 / num);
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
		if(activeQuestion != -1 || isSure()){
			return true;
		}
		return false;
	}

    public String getQuestion(Language lang){
		if(isSure()){
			return null;
		}
		if(activeQuestion != -1 && column[activeQuestion] != "null"){
			return giveQuestion(column[activeQuestion], lang);
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
		//System.out.println(question[maxNr]);
		return giveQuestion(column[maxNr], lang);
    }

	private String giveQuestion(String columnName, Language lang){
		String ques = null;
		try{
			Statement st = DatabaseProvider.getStatement();
			st.execute("SELECT * from " + columnName + "_QUESTIONS WHERE ID='" + question[activeQuestion] + "'");
			//System.out.println("SELECT * from " + columnName +"_QUESTIONS ");
			ResultSet res = st.getResultSet();
			res.next();
			if(lang.equals(Language.GERMAN)){
				ques = res.getString("Q1_DE");
			}else if(lang.equals(Language.ENGLISH)){
				ques = res.getString("Q1_EN");
			}
		}catch(SQLException e){
			System.out.println("SELECT * from " + columnName + "_QUESTIONS WHERE ID='" + question[activeQuestion] + "'");
			e.printStackTrace();
		}
		System.out.println(ques);
		return ques;
	}

	private float tryQuestion(int columnID){
		try{
			Statement st = DatabaseProvider.getStatement();
			String select = "SELECT count(0) as C, "+ column[columnID] +" FROM SIMPSONS GROUP BY "+ column[columnID];
			if(activeQuestion != -1){
				select += " WHERE ";
				boolean first = true;
				for(int i = 0; i < column.length; i++){
					if(ans != null){
						if(!first){
							select += "AND ";
						}else{
							first = false;
						}
						select += "SIMPSONS."+ column[i] +"="+ column[i] +"_QUESTIONS.ID ";
					}
				}
			}
			st.execute(select);
			ResultSet res = st.getResultSet();
			float max = 0;
			float sum = 0;
			while(res.next()){
				float val = res.getInt("C");
				if(val > max){
					max = val;
					question[columnID] = res.getString(column[columnID]);
				}
				sum += val;
			}
			float ret = max / sum;
			ret += Math.random()*0.2;
			if(ret > 0.5){
				ret = 1 - ret;
			}
			return ret;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return -1;
	}
}
