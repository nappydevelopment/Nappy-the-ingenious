package nappydevelopment.nappy_the_ingenious.gamemodes.gamemode2;

import nappydevelopment.nappy_the_ingenious.data.Answer;
import nappydevelopment.nappy_the_ingenious.data.Character;
import nappydevelopment.nappy_the_ingenious.exception.GameHasFinished;
import nappydevelopment.nappy_the_ingenious.exception.InvalidQuestion;
import nappydevelopment.nappy_the_ingenious.exception.NoMoreQuestions;

import java.util.List;

public interface GM2State{
	public int answeredQuestions();
	public List<String> getQuestions() throws GameHasFinished;
	public Answer askQuestion(final String question) throws NoMoreQuestions, InvalidQuestion, GameHasFinished;
	public Boolean makeGuess(final Character wiki) throws GameHasFinished;
	public Boolean makeGuess(final String name) throws GameHasFinished;
	public boolean isFinished();
	public Character endGame(Gamemode2 gm2) throws GameHasFinished;
}
