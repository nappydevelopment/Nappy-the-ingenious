package nappydevelopment.nappyTheIngenious.gamemodes.gamemode1;

import nappydevelopment.nappyTheIngenious.data.Answer;
import nappydevelopment.nappyTheIngenious.data.Sureness;
import nappydevelopment.nappyTheIngenious.data.character.Character;
import nappydevelopment.nappyTheIngenious.exception.GameHasFinished;

public class GM1FinishedState implements GM1State{
	private int numDunno;
	private Sureness sure;

	public GM1FinishedState(int numDunno, Sureness sure){
		this.numDunno = numDunno;
		this.sure = sure;
	}

	@Override
	public int getNumDunno(){
		return numDunno;
	}

	@Override
	public Sureness isSure(){
		return sure;
	}

	@Override
	public boolean isActive(){ return false; }

	@Override
	public boolean isFinished(){ return true; }

	@Override
	public Character endGame(GameMode1 gameMode1) throws GameHasFinished{
		throw new GameHasFinished();
	}

	@Override
	public void setAnswer(Answer answer) throws GameHasFinished{
		throw new GameHasFinished();
	}

	@Override
	public float getSureness() throws GameHasFinished{
		throw new GameHasFinished();
	}

	@Override
	public String getQuestion() throws GameHasFinished{
		throw new GameHasFinished();
	}
}
