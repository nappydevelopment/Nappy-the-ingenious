package nappydevelopment.nappyTheIngenious.gamemodes.gamemode1;

import nappydevelopment.nappyTheIngenious.data.Answer;
import nappydevelopment.nappyTheIngenious.data.Sureness;
import nappydevelopment.nappyTheIngenious.data.character.Character;
import nappydevelopment.nappyTheIngenious.exception.CantFinishGamemMode;
import nappydevelopment.nappyTheIngenious.exception.GameHasFinished;
import nappydevelopment.nappyTheIngenious.exception.NoActiveQuestion;
import nappydevelopment.nappyTheIngenious.exception.NoMoreQuestions;

public interface GM1State{
	Character endGame() throws GameHasFinished, CantFinishGamemMode;
	void setAnswer(final Answer answer) throws NoActiveQuestion, GameHasFinished;
	int getNumDunno();
	float getSureness() throws GameHasFinished;
	Sureness isSure();
	boolean isActive();
	boolean isFinished();
	String getQuestion(final boolean deterministic) throws NoMoreQuestions, GameHasFinished;
}
