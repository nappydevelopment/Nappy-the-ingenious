package nappydevelopment.nappyTheIngenious.gamemodes.gamemode1;

import nappydevelopment.nappyTheIngenious.data.Answer;
import nappydevelopment.nappyTheIngenious.data.CharacterProvider;
import nappydevelopment.nappyTheIngenious.data.DatabaseProvider;
import nappydevelopment.nappyTheIngenious.data.Sureness;
import nappydevelopment.nappyTheIngenious.data.character.Character;
import nappydevelopment.nappyTheIngenious.data.settings.Language;
import nappydevelopment.nappyTheIngenious.exception.CantFinishGamemMode;
import nappydevelopment.nappyTheIngenious.exception.GameHasFinished;
import nappydevelopment.nappyTheIngenious.exception.NoActiveQuestion;
import nappydevelopment.nappyTheIngenious.exception.NoMoreQuestions;
import nappydevelopment.nappyTheIngenious.gamemodes.Question;
import nappydevelopment.nappyTheIngenious.gamemodes.QuestionProvider;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class GM1RunningState implements GM1State{
	private int numDunno = 0;
	private boolean deterministic = false;

	private Map<String, Question> questions;
	private Question activeQuestion = null;

	public GM1RunningState(final Language lang, final boolean det){
		deterministic = det;
		questions = QuestionProvider.getQuestions(lang);
	}
	@Override
	public boolean isFinished(){
		return false;
	}

	@Override
	public Character endGame(GameMode1 gameMode1) throws GameHasFinished, CantFinishGamemMode{
		List<Character> chars = CharacterProvider.getCharacters(generateWhere());
		if(chars.isEmpty() || isSure() != Sureness.SURE){
			throw new CantFinishGamemMode();
		}
		gameMode1.state = new GM1FinishedState(numDunno, isSure());
		return chars.get(0);
	}

	@Override
	public void setAnswer(final Answer answer) throws NoActiveQuestion {
		if(answer == null){
			return;
		}
		if(answer == Answer.DONT_KNOW){
			numDunno++;
		}
		if(activeQuestion == null){
			throw new NoActiveQuestion();
		}
		questions.get(activeQuestion.getQuestion()).setAnswer(answer);
		activeQuestion = null;
	}

	@Override
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
		boolean first = true;
		for(Question question : questions.values()){
			where += question.genWhere(first);
			if(first && !" WHERE ".equals(where)){
				first = false;
			}
		}
		if(" WHERE ".equals(where)){
			return "";
		}
		return where;
	}

	@Override
	public float getSureness(){
		float sureness = this.sureness();
		if(sureness < 0){
			return 0;
		}
		return sureness;
	}

	@Override
	public Sureness isSure(){
		float sureness = this.sureness();
		Sureness ret = Sureness.UNSURE;
		if(sureness == 1){
			ret = Sureness.SURE;
		}
		if(sureness < 0){
			ret = Sureness.DONTKNOW;
		}
		return ret;
	}

	@Override
	public boolean isActive(){ return activeQuestion != null; }

	@Override
	public String getQuestion() throws NoMoreQuestions{
		if(isSure()==Sureness.SURE){
			return null;
		}
		if(activeQuestion != null){
			return activeQuestion.getQuestion();
		}
		Optional<Question> bestMatch = questions.values().stream()
				.filter(q -> !q.answered())
				.max((q1, q2) -> Float.compare(
						q1.tryQuestion(generateWhere(), deterministic),
						q2.tryQuestion(generateWhere(), deterministic)
						)
				);
		if(bestMatch.isPresent()){
			activeQuestion = bestMatch.get();
		}else{
			activeQuestion = null; // just to be sure
			throw new NoMoreQuestions();
		}
		return activeQuestion.getQuestion();
	}
}
