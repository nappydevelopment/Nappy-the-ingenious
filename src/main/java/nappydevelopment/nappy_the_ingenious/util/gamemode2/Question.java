package nappydevelopment.nappy_the_ingenious.util.gamemode2;

import nappydevelopment.nappy_the_ingenious.data.Answer;
import nappydevelopment.nappy_the_ingenious.data.DatabaseProvider;
import nappydevelopment.nappy_the_ingenious.data.settings.Language;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Question{

	private final String table;
	private final String attribute;
	private final String question;
	private final Language lang;

	private Answer answer = null;

	public Question(
			String table,
			String attribute,
			Language lang,
			String question
	){
		this.table = table;
		this.attribute = attribute;
		this.question = question;
		this.lang = lang;
	}
	public String toString(){ return question; }
	public String getQuestion(){ return question; }
	public String getAttribute(){ return attribute; }
	public String getTable(){ return table; }
	public Language getLanguage(){ return lang; }

	// stuff for GameMode1
	public boolean answered(){ return answer != null; }
	public void setAnswer(Answer answer){
		if(this.answer != null){
			return;
		}
		this.answer = answer;
	}
	public float tryQuestion(final String where, final boolean deterministic){
		String select = "SELECT count(0) as C, " + table +
				" FROM SIMPSONS " + where + " GROUP BY " + table;
		float sum = 0;
		float ret = 0;
		try(Statement st = DatabaseProvider.getStatement()){
			st.execute(select);
			ResultSet res = st.getResultSet();
			while(res.next()){
				float val = res.getInt("C");
				if(attribute.equals(res.getString(table))){
					ret = val;
				}
				sum += val;
			}
			if(!deterministic){
				ret += Math.random()*(sum/2);
				if(ret > sum){
					sum += ret;
				}
			}
			ret = ret / sum;
			if(ret > 0.5){
				ret = 1 - ret;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ret;
	}

	public String genWhere(boolean first){
		String where = "";
		if(answer == Answer.DONT_KNOW || answer == null){
			return where;
		}
		if(!first){
			where += " AND ";
		}
		where += "SIMPSONS." + table;
		if(answer == Answer.YES){
			where += " !";
		}
		where += "= '" + attribute + "' ";
		return where;
	}
}
