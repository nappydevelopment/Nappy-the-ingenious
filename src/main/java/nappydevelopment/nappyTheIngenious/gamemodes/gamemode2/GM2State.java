package nappydevelopment.nappyTheIngenious.gamemodes.gamemode2;

import nappydevelopment.nappyTheIngenious.data.Answer;
import nappydevelopment.nappyTheIngenious.data.character.Character;
import nappydevelopment.nappyTheIngenious.exception.GameHasFinished;
import nappydevelopment.nappyTheIngenious.exception.InvalidQuestion;

import java.util.List;
import java.util.Map;

public interface GM2State{
	int answeredQuestions();
	Answer askQuestion(final String question) throws InvalidQuestion, GameHasFinished;
	Boolean makeGuess(final String name) throws GameHasFinished;
	Character endGame(final GameMode2 gm2) throws GameHasFinished;
	List<String> getQuestions() throws GameHasFinished;
	Map<String, Answer> getSortedQuestionAnswerMap() throws GameHasFinished;
	boolean isFinished();
}
