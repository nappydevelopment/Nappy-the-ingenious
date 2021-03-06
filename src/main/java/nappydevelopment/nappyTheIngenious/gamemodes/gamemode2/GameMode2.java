package nappydevelopment.nappyTheIngenious.gamemodes.gamemode2;

import nappydevelopment.nappyTheIngenious.data.Answer;
import nappydevelopment.nappyTheIngenious.data.QuestAnsList;
import nappydevelopment.nappyTheIngenious.data.character.Character;
import nappydevelopment.nappyTheIngenious.data.settings.Language;
import nappydevelopment.nappyTheIngenious.exception.GameHasFinished;
import nappydevelopment.nappyTheIngenious.exception.InvalidQuestion;

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

	public Answer askQuestion(final String question) throws InvalidQuestion, GameHasFinished {
		return state.askQuestion(question);
	}

	public int answeredQuestions(){ return state.answeredQuestions(); }
	public List<String> getQuestions() throws GameHasFinished{ return state.getQuestions(); }
	public QuestAnsList getQuestionAnswerList() throws GameHasFinished{ return state.getQuestionAnswerList(); }
	public Boolean makeGuess(final Character wiki) throws GameHasFinished{ return makeGuess(wiki.getName()); }
	public Boolean makeGuess(final String name) throws GameHasFinished{ return state.makeGuess(name); }
	public boolean isFinished(){ return state.isFinished(); }
	public Character endGame() throws GameHasFinished{ return state.endGame(this); }
}
