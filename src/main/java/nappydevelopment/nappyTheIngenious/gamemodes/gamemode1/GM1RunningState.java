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
	protected int numDunno = 0;
	private Map<String, Question> questions;
	private GameMode1 context;

	public GM1RunningState(final GameMode1 ctx, final Language lang){
		context = ctx;
		questions = QuestionProvider.getQuestions(lang);
	}
	@Override
	public int getNumDunno(){ return numDunno; }

	@Override
	public boolean isActive(){ return false; }

	@Override
	public boolean isFinished(){ return false; }

	@Override
	public Character endGame() throws GameHasFinished, CantFinishGamemMode{
		List<Character> chars = CharacterProvider.getCharacters(generateWhere());
		if(chars.isEmpty() || isSure() != Sureness.SURE){
			throw new CantFinishGamemMode();
		}
		context.state = new GM1FinishedState(numDunno, isSure());
		return chars.get(0);
	}

	@Override
	public void setAnswer(final Answer answer) throws NoActiveQuestion {
		throw new NoActiveQuestion();
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

	protected void questionsAttributeAnswered(Question question){
		questions.values().stream().map(q -> q.attributeAnswered(question));
	}

	@Override
	public String getQuestion(final boolean deterministic) throws NoMoreQuestions{
		if(isSure() == Sureness.SURE){
			return null;
		}
		Optional<Question> bestMatch = questions.values().stream()
				.filter(q -> !q.answered())
				.max((q1, q2) -> Float.compare(
						q1.tryQuestion(generateWhere(), deterministic),
						q2.tryQuestion(generateWhere(), deterministic)
						)
				);
		if(!bestMatch.isPresent()){
			throw new NoMoreQuestions();
		}
		Question activeQuestion = bestMatch.get();
		context.state = new GM1ActiveState(activeQuestion, context, this);
		return activeQuestion.getQuestion();
	}
}
