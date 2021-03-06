package nappydevelopment.nappyTheIngenious.gamemodes;

import nappydevelopment.nappyTheIngenious.data.DatabaseProvider;
import nappydevelopment.nappyTheIngenious.data.settings.Language;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class QuestionProvider{
	public static Map<String, Question> getQuestions(final Language lang){
		Map<String, Question> questions = null;
		try(Statement st = DatabaseProvider.getStatement()){
			questions = new HashMap<>();
			StringBuffer questionSelect = new StringBuffer(" Select TABL, ID, Q1_" + lang.getCode() + " from (");
			st.execute(
				"SELECT * FROM INFORMATION_SCHEMA.COLUMNS \n" +
				"WHERE TABLE_NAME = 'SIMPSONS'\n" +
				"AND COLUMN_NAME NOT IN ('ID', 'NAME', 'COUNTER')\n" +
				"AND COLUMN_NAME NOT LIKE 'DESCRIPTION_%'\n" +
				"AND COLUMN_NAME NOT LIKE 'NICKNAME_%'"
			);
			ResultSet res = st.getResultSet();
			boolean first = true;
			while(res.next()){
				if(!first){
					questionSelect.append(" UNION ");
				}else{
					first = false;
				}
				questionSelect.append(" SELECT cast(id as varchar) as ID, '");
				questionSelect.append(res.getString("COLUMN_NAME") + "' as TABL, Q1_" + lang.getCode());
				questionSelect.append(" FROM " + res.getString("COLUMN_NAME") + "_QUESTIONS");
			}
			res.close();

			questionSelect.append(") WHERE Q1_" + lang.getCode() + "!= 'YOU SHOULD NOT READ THIS!'");
			st.execute(questionSelect.toString());
			res = st.getResultSet();
			while(res.next()){
				String question = res.getString("Q1_" + lang.getCode());
				questions.put(question, new Question(
					res.getString("TABL"),
					res.getString("ID"),
					lang,
					question
				));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return questions;
	}
}
