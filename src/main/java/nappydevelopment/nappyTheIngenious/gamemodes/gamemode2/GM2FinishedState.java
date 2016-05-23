package nappydevelopment.nappyTheIngenious.gamemodes.gamemode2;

import nappydevelopment.nappyTheIngenious.data.Answer;
import nappydevelopment.nappyTheIngenious.data.character.Character;
import nappydevelopment.nappyTheIngenious.exception.GameHasFinished;

import java.util.List;
import java.util.Map;

public class GM2FinishedState implements GM2State{
	private final int answeredQuestions;
	public GM2FinishedState(final int answeredQuestions){
		this.answeredQuestions = answeredQuestions;
	}

	public boolean isFinished(){ return true; }
	public int answeredQuestions(){ return answeredQuestions; }

	public Answer askQuestion(final String question) throws GameHasFinished{
		throw new GameHasFinished();
	}
	public Boolean makeGuess(final String name) throws GameHasFinished{
		throw new GameHasFinished();
	}
	public Character endGame(final GameMode2 gm2) throws GameHasFinished{
		throw new GameHasFinished();
	}
	public List<String> getQuestions() throws GameHasFinished{
		throw new GameHasFinished();
	}
	public Map<String, Answer> getSortedQuestionAnswerMap() throws GameHasFinished{
		throw new GameHasFinished();
	}
}
