package nappydevelopment.nappyTheIngenious.gamemodes.gamemode1;

import nappydevelopment.nappyTheIngenious.data.Answer;
import nappydevelopment.nappyTheIngenious.data.Sureness;
import nappydevelopment.nappyTheIngenious.data.character.Character;
import nappydevelopment.nappyTheIngenious.data.settings.Language;
import nappydevelopment.nappyTheIngenious.exception.CantFinishGamemMode;
import nappydevelopment.nappyTheIngenious.exception.GameHasFinished;
import nappydevelopment.nappyTheIngenious.exception.NoActiveQuestion;
import nappydevelopment.nappyTheIngenious.exception.NoMoreQuestions;

public class GameMode1{
	GM1State state;
	public GameMode1(final Language lang){
		state = new GM1RunningState(this, lang);
	}

	public Character endGame() throws GameHasFinished, CantFinishGamemMode{ return state.endGame(); }
	public void setAnswer(final Answer answer) throws NoActiveQuestion, GameHasFinished{ state.setAnswer(answer); }
	public int getNumDunno(){ return state.getNumDunno(); }
	public float getSureness() throws GameHasFinished{ return state.getSureness(); }
	public Sureness isSure(){ return state.isSure(); }
	public boolean isActive(){ return state.isActive(); }
	public boolean isFinished(){ return state.isFinished(); }
	public String getQuestion() throws NoMoreQuestions, GameHasFinished{ return state.getQuestion(false); }
	public String getQuestion(final boolean det) throws NoMoreQuestions, GameHasFinished{ return state.getQuestion(det); }

}
