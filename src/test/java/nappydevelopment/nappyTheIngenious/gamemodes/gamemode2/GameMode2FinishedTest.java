package nappydevelopment.nappyTheIngenious.gamemodes.gamemode2;

import nappydevelopment.nappyTheIngenious.data.character.Character;
import nappydevelopment.nappyTheIngenious.data.settings.Language;
import nappydevelopment.nappyTheIngenious.exception.GameHasFinished;
import nappydevelopment.nappyTheIngenious.exception.InvalidQuestion;
import nappydevelopment.nappyTheIngenious.exception.NoMoreQuestions;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameMode2FinishedTest{
	private GameMode2 gm;
	private Language lang = Language.values()[0];

	@Before
	public void init() throws Exception{
		gm = new GameMode2(lang);
		gm.askQuestion(gm.getQuestions().get(0));
		gm.endGame();
	}

	@Test
	public void finished(){
		assertTrue(gm.isFinished());
	}
	@Test
	public void answeredQuestions()
			throws GameHasFinished, NoMoreQuestions, InvalidQuestion
	{
		assertEquals(gm.answeredQuestions(), 1);
	}
	@Test(expected=GameHasFinished.class)
	public void askQuestion() throws Exception{
		assertNull(gm.askQuestion("EGAL"));
	}
	@Test(expected=GameHasFinished.class)
	public void doubleEndGame() throws GameHasFinished{
		assertNull(gm.endGame());
	}
	@Test(expected=GameHasFinished.class)
	public void getQuestions() throws GameHasFinished{
		assertNull(gm.getQuestions());
	}
	@Test(expected=GameHasFinished.class)
	public void makeGuess() throws GameHasFinished{
		gm.makeGuess("EGAL");
	}
	@Test(expected=GameHasFinished.class)
	public void makeCharacterGuess() throws GameHasFinished{
		assertNull(gm.makeGuess(new Character(null,null,null,null,null,null)));
	}
	@Test(expected=GameHasFinished.class)
	public void getQuestionsMap() throws GameHasFinished{
		gm.getSortedQuestionAnswerMap();
	}
}
