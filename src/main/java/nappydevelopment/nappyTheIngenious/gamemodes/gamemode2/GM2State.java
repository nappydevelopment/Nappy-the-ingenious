package nappydevelopment.nappyTheIngenious.gamemodes.gamemode2;

import nappydevelopment.nappyTheIngenious.data.Answer;
import nappydevelopment.nappyTheIngenious.data.QuestAnsList;
import nappydevelopment.nappyTheIngenious.data.character.Character;
import nappydevelopment.nappyTheIngenious.exception.GameHasFinished;
import nappydevelopment.nappyTheIngenious.exception.InvalidQuestion;

import java.util.List;

public interface GM2State{
	int answeredQuestions();
	Answer askQuestion(final String question) throws InvalidQuestion, GameHasFinished;
	Boolean makeGuess(final String name) throws GameHasFinished;
	Character endGame(final GameMode2 gm2) throws GameHasFinished;
	List<String> getQuestions() throws GameHasFinished;
	QuestAnsList getQuestionAnswerList() throws GameHasFinished;
	boolean isFinished();
}
