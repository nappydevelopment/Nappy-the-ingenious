package nappydevelopment.nappy_the_ingenious.util.gamemode1;

import javafx.scene.image.Image;
import nappydevelopment.nappy_the_ingenious.GlobalReferences;
import nappydevelopment.nappy_the_ingenious.data.DatabaseProvider;
import nappydevelopment.nappy_the_ingenious.data.WikiCharacter;
import nappydevelopment.nappy_the_ingenious.data.settings.Language;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Gamemode1{

	private String[] column = new String[60];
	private boolean[] columnBool = new boolean[60];
	private Boolean[] ans = new Boolean[60];
	private String[] question = new String[60];
	private boolean[] dunno = new boolean[60];
	private int remaining = 0;
	private int numDunno = 0;
	private int activeQuestion = -1;
	private boolean determinisic = false;
	private boolean firstQuestion = true;

    public Gamemode1(){
		try(Statement st = DatabaseProvider.getStatement()){
        	st.execute(
				"SELECT * FROM INFORMATION_SCHEMA.COLUMNS \n" +
				"WHERE TABLE_NAME = 'SIMPSONS'\n" +
				"AND COLUMN_NAME NOT IN ('ID', 'NAME', 'NICKNAME', 'COUNTER')\n" +
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
		}catch(SQLException e){
			e.printStackTrace();
		}
    }

	public Gamemode1(boolean det){
		super();
		determinisic = det;
	}

	public WikiCharacter getCharacter(Language lang){
		String select = "SELECT name, nickname, description_en, description_de FROM SIMPSONS";
		boolean first = true;
		select += generateWhere();
		try(Statement st = DatabaseProvider.getStatement()){
			st.execute(select);
			ResultSet res = st.getResultSet();
			if(!res.next()){
				// not a valid character :O
				return null;
			}
			return new WikiCharacter(
				res.getString("name"),
				res.getString("nickname"),
				res.getString("description_" + lang.getCode().toLowerCase()),
				new Image(GlobalReferences.IMAGES_PATH + "wiki/" + res.getString("name").toLowerCase().replace(" ", "_") + ".png")
			);
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
		String where = generateWhere();
		if(where.isEmpty()){
			return 0;
		}
		try(Statement st = DatabaseProvider.getStatement()){
			st.execute("Select count(0) as C FROM SIMPSONS" + where);
			ResultSet res = st.getResultSet();
			res.next();
			float count = res.getFloat("C");
			res.close();
			if(count == 0){
				return -2;
			}
			return (1 / count);
		}catch(Throwable e){
			e.printStackTrace();
		}
		return -1;
	}

	private String generateWhere(){
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
		return where;
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
		try(Statement st = DatabaseProvider.getStatement()){
			st.execute("SELECT * from " + column[columnNr] + "_QUESTIONS WHERE ID='" + question[activeQuestion] + "'");
			ResultSet res = st.getResultSet();
			res.next();
			ques = res.getString("Q1_" + lang.getCode());
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ques;
	}

	private float tryQuestion(int columnID){
		String select = "SELECT count(0) as C, " + column[columnID] +
				" FROM SIMPSONS" + generateWhere() + " GROUP BY " + column[columnID];
		float max = 0;
		float sum = 0;
		float ret = 0;
		try(Statement st = DatabaseProvider.getStatement()){
			st.execute(select);
			ResultSet res = st.getResultSet();
			while(res.next()){
				float val = res.getInt("C");
				if(!determinisic){
					val += Math.random()*(max/2);
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
