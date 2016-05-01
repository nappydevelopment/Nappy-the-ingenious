package nappydevelopment.nappy_the_ingenious.util.gamemode1;

import nappydevelopment.nappy_the_ingenious.data.*;
import nappydevelopment.nappy_the_ingenious.data.settings.Language;
import nappydevelopment.nappy_the_ingenious.util.gamemode2.Question;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class Gamemode1{
	private int numDunno = 0;
	private Question activeQuestion = null;

	private Language lang;
	private boolean deterministic = false;
	private boolean firstQuestion = true;

	private Map<String, Question> questions;

	public Gamemode1(Language l){ this(l, false); }
	public Gamemode1(Language l, final boolean det){
		deterministic = det;
		lang = l;
		questions = QuestionProvider.getQuestions(lang);
	}

	public WikiCharacter getCharacter(){
		List<WikiCharacter> chars = CharacterProvider.getCharacters(generateWhere());
		if(chars.isEmpty() || !isSure()){
			return null;
		}
		return chars.get(0);
	}

    public void setAnswer(final Answer answer){
		if(answer == null){
			return;
		}
		if(answer == Answer.DONT_KNOW){
			numDunno++;
		}
		questions.get(activeQuestion.getQuestion()).setAnswer(answer);
		activeQuestion = null;
		firstQuestion = false;
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
			if(res.next()){
				float count = res.getFloat("C");
				res.close();
				if(count == 0){
					return -2;
				}
				return (1 / count);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return -1;
	}

	private String generateWhere(){
		String where = " WHERE ";
		if(firstQuestion == false){
			boolean first = true;
			for(Question question : questions.values()){
				where += question.genWhere(first);
				if(first && !" WHERE ".equals(where)){
					first = false;
				}
			}
		}
		if(" WHERE ".equals(where)){
			return "";
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
		return activeQuestion != null;
	}

    public String getQuestion(){
		if(isSure()){
			return null;
		}
		if(activeQuestion != null){
			return activeQuestion.getQuestion();
		}
		try{
			activeQuestion = questions.values().stream()
				.filter(q -> !q.answered())
				.max((q1, q2) -> Float.compare(
					q1.tryQuestion(generateWhere(), deterministic),
					q2.tryQuestion(generateWhere(), deterministic)
				)
			).get();
		}catch(NoSuchElementException e){
			activeQuestion = null; // just to be sure
			return null;
		}
		return activeQuestion.getQuestion();
    }

}
