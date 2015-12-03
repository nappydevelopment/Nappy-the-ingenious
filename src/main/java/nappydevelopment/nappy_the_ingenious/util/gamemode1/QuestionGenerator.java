package nappydevelopment.nappy_the_ingenious.util.gamemode1;

import nappydevelopment.nappy_the_ingenious.data.DatabaseProvider;
import nappydevelopment.nappy_the_ingenious.data.WikiCharacter;
import nappydevelopment.nappy_the_ingenious.data.settings.Language;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QuestionGenerator{

    private String[] column = new String[40];
    private Boolean[] ans = new Boolean[40];
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

	public static void main(String[] args){
		QuestionGenerator p = new QuestionGenerator();
		System.out.println(p.getQuestion(Language.GERMAN));
		p.setAnswer(false);
		System.out.println(p.getQuestion(Language.ENGLISH));
		System.out.println(p.getQuestion(Language.ENGLISH));
		p.setAnswer(true);
		System.out.println(p.isSure());
		System.out.println(p.getQuestion(Language.GERMAN));
		p.setAnswer(false);
		System.out.println(p.getQuestion(Language.ENGLISH));
		System.out.println(p.isSure());
	}

	public WikiCharacter getCharacter(){
		Statement st = DatabaseProvider.getStatement();
		return null;
	}

    public void setAnswer(boolean answer){
		if(activeQuestion != -1){
			ans[activeQuestion] = answer;
			activeQuestion = -1;
		}
    }

    public boolean isSure(){
		if(true){
			return false;
		}
		Statement st = DatabaseProvider.getStatement();
		String select = "Select count(0) FROM SIMPSONS WHERE";
		boolean first = true;
		for(int i = 0; i < column.length; i++){
			if(column[i] == null){
				break;
			}
		}
		//st.execute(""); //TODO: gen query
		ResultSet res = null;
		try{
			res = st.getResultSet();
			res.next();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
    }

    public String getQuestion(Language lang){
		if(activeQuestion != -1){
			return null;
		}
		float localMax;
		float max = 0;
		int maxNr = -1;
		for(int i = 0; i < column.length; i++){
			if(column[i] == null){
				break;
			}
			if(ans[i] != null){
				continue;
			}
			localMax = tryQuestion(column[i]);
			if(localMax >= max){
				max = localMax;
				maxNr = i;
			}
		}
		if(maxNr == -1 || max <= 0){
			System.out.println(maxNr +" "+ max);
			return null;
		}
		activeQuestion = maxNr;
		return giveQuestion(column[maxNr], lang);
    }

	private String giveQuestion(String columnName, Language lang){
		String ques = null;
		try{
			Statement st = DatabaseProvider.getStatement();
			st.execute("SELECT * from "+ columnName +"_QUESTIONS ");
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

	private float tryQuestion(String columnName){
		try{
			Statement st = DatabaseProvider.getStatement();
			String select = "SELECT count(0) as C FROM SIMPSONS GROUP BY "+ columnName;
			if(activeQuestion != -1){
				select += " WHERE ";
				boolean f = true;
				for(int i = 0; i < column.length; i++){
					if(ans != null){
						if(!f){
							select += "AND ";
						}else{
							f=false;
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
				}
				sum += val;
			}
			float ret = max / sum;
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
