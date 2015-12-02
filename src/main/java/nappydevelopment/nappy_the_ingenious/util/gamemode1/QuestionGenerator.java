package nappydevelopment.nappy_the_ingenious.util.gamemode1;

import nappydevelopment.nappy_the_ingenious.data.DatabaseProvider;
import nappydevelopment.nappy_the_ingenious.data.settings.Language;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.stream.IntStream;

public class QuestionGenerator{

    private String[] column = new String[40];
    private Boolean[] ans = new Boolean[40];
	private int activeQuestion;

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
	}

    public void setAnswer(){
    }

    public boolean isSure(){
		Statement st = DatabaseProvider.getStatement();
		//st.execute(""); //TODO: gen query
        return false;
    }

    public String getQuestion(Language lang){
		//???
		float localMax;
		float max = 0;
		int maxNr = -1;
		for(int i = 0; i < column.length; i++){
			if(column[i] == null){
				break;
			}
			localMax = tryQuestion(column[i]);
			if(localMax >= max){
				max = localMax;
				maxNr = i;
			}
		}
		if(maxNr == -1 || max <= 0){
			System.out.println("FUCK");
			System.out.println(maxNr + ", " + max);
			return null;
		}
		activeQuestion = maxNr;
		return giveQuestion(column[maxNr], lang);
    }

	private String giveQuestion(String column, Language lang){
		String ques = null;
		try{
			Statement st = DatabaseProvider.getStatement();
			st.execute(
				"SELECT * from "+ column +"_QUESTIONS "
			);
			ResultSet res = st.getResultSet();
			res.next();
			if(lang.equals(Language.GERMAN)){
				ques = res.getString("Q1_DE");
			}else if(lang.equals(Language.ENGLISH)){
				ques = res.getString("Q1_EN");
			}

			System.out.println(column);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ques;
	}

	private float tryQuestion(String columnName){
		try{
			Statement st = DatabaseProvider.getStatement();
			st.execute("SELECT count(0) as C FROM SIMPSONS GROUP BY " + columnName);
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
				ret -= 0.5;
			}
			System.out.println(columnName+": "+ret);
			return ret;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return -1;
	}
}
