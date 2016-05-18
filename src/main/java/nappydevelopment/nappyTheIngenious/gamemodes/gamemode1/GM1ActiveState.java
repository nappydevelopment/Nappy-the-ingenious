package nappydevelopment.nappyTheIngenious.gamemodes.gamemode1;

import nappydevelopment.nappyTheIngenious.data.Answer;
import nappydevelopment.nappyTheIngenious.data.Sureness;
import nappydevelopment.nappyTheIngenious.data.character.Character;
import nappydevelopment.nappyTheIngenious.exception.CantFinishGameMode;
import nappydevelopment.nappyTheIngenious.exception.GameHasFinished;
import nappydevelopment.nappyTheIngenious.exception.NoActiveQuestion;
import nappydevelopment.nappyTheIngenious.gamemodes.Question;

public class GM1ActiveState implements GM1State{
	private GM1RunningState lastState;
	private GameMode1 context;
	private Question question;

	public GM1ActiveState(Question q, GameMode1 gm1, GM1RunningState gm1rs){
		lastState = gm1rs;
		context = gm1;
		question = q;
	}

	@Override
	public void setAnswer(Answer answer) throws NoActiveQuestion, GameHasFinished{
		if(answer == null){
			return;
		}
		if(answer == Answer.DONT_KNOW){
			lastState.numDunno++;
		}
		question.setAnswer(answer);
		lastState.questionsAttributeAnswered(this.question);

		context.state = lastState;
	}

	@Override
	public Character endGame() throws GameHasFinished, CantFinishGameMode{
		throw new CantFinishGameMode();
	}

	@Override
	public int getNumDunno(){ return lastState.getNumDunno(); }

	@Override
	public float getSureness() throws GameHasFinished{ return lastState.getSureness(); }

	@Override
	public Sureness isSure(){ return lastState.isSure(); }

	@Override
	public boolean isActive(){ return true; }

	@Override
	public boolean isFinished(){ return false; }

	@Override
	public String getQuestion(final boolean det){ return question.getQuestion(); }
}
