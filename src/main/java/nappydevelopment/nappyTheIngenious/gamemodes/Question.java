package nappydevelopment.nappyTheIngenious.gamemodes;

import nappydevelopment.nappyTheIngenious.data.Answer;
import nappydevelopment.nappyTheIngenious.data.DatabaseProvider;
import nappydevelopment.nappyTheIngenious.data.settings.Language;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Question{

	private final String table;
	private final String attribute;
	private final String question;
	private final Language lang;
	private final boolean bool;

	private Answer answer = null;
	private boolean attributeAnswered = false;


	public Question(
		final String table,
		final String attribute,
		final Language lang,
		final String question
	){
		this.table = table;
		this.attribute = attribute;
		this.question = question;
		this.lang = lang;
		this.bool = "TRUE".equals(attribute) || "FALSE".equals(attribute);
	}
	public String getQuestion(){ return question; }
	public String getAttribute(){ return attribute; }
	public String getTable(){ return table; }
	public Language getLanguage(){ return lang; }

	// stuff for GameMode1
	public Answer getAnswer(){ return answer; }
	public boolean answered(){ return answer != null || attributeAnswered; }
	public void setAnswer(final Answer answer){
		if(this.answer != null){
			return;
		}
		this.answer = answer;
	}
	public Question attributeAnswered(Question q){
		if((q.getAnswer() == Answer.YES || bool) && attribute.equals(q.getAttribute())){
			attributeAnswered = true;
		}
		return this; // for predicate usage
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
			}
			ret = Math.min(ret, sum) / Math.max(ret, sum);
			if(ret > 0.5){
				ret = 1 - ret;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ret;
	}

	public String genWhere(final boolean first){
		StringBuffer where = new StringBuffer();
		if(answer == Answer.DONT_KNOW || answer == null){
			return where.toString();
		}
		if(!first){
			where.append(" AND ");
		}
		where.append("SIMPSONS." + table);
		if(answer == Answer.NO){
			where.append(" !");
		}
		where.append("= '" + attribute + "' ");
		return where.toString();
	}
}
