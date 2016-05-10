package nappydevelopment.nappy_the_ingenious.gamemodes.gamemode2;

import nappydevelopment.nappy_the_ingenious.data.Answer;
import nappydevelopment.nappy_the_ingenious.data.Character;
import nappydevelopment.nappy_the_ingenious.exception.GameHasFinished;
import nappydevelopment.nappy_the_ingenious.exception.InvalidQuestion;
import nappydevelopment.nappy_the_ingenious.exception.NoMoreQuestions;

import java.util.List;

public interface GM2State{
	int answeredQuestions();
	Answer askQuestion(final String question) throws NoMoreQuestions, InvalidQuestion, GameHasFinished;
	Boolean makeGuess(final Character wiki) throws GameHasFinished;
	Boolean makeGuess(final String name) throws GameHasFinished;
	Character endGame(final GameMode2 gm2) throws GameHasFinished;
	List<String> getQuestions() throws GameHasFinished;
	boolean isFinished();
}
