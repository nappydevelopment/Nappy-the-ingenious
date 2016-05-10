package nappydevelopment.nappy_the_ingenious.gamemodes.gamemode2;

import nappydevelopment.nappy_the_ingenious.data.Answer;
import nappydevelopment.nappy_the_ingenious.data.Character;
import nappydevelopment.nappy_the_ingenious.data.settings.Language;
import nappydevelopment.nappy_the_ingenious.exception.GameHasFinished;
import nappydevelopment.nappy_the_ingenious.exception.InvalidQuestion;
import nappydevelopment.nappy_the_ingenious.exception.NoMoreQuestions;

import java.util.List;


public class GameMode2{

	GM2State state;

	public GameMode2(final Language l){ this(l, false); }
	public GameMode2(
		final Language lang,
		final boolean deterministic
	){
		state = new GM2RunningState(lang, deterministic);
	}

	public Answer askQuestion(final String question) throws NoMoreQuestions, InvalidQuestion, GameHasFinished {
		return state.askQuestion(question);
	}

	public int answeredQuestions(){ return state.answeredQuestions(); }
	public List<String> getQuestions() throws GameHasFinished{ return state.getQuestions(); }
	public Boolean makeGuess(final Character wiki) throws GameHasFinished{ return makeGuess(wiki.getName()); }
	public Boolean makeGuess(final String name) throws GameHasFinished{ return state.makeGuess(name); }
	public boolean isFinished(){ return state.isFinished(); }
	public Character endGame() throws GameHasFinished{ return state.endGame(this); }
}
