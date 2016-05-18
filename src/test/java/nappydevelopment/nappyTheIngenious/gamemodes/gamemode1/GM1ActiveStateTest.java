package nappydevelopment.nappyTheIngenious.gamemodes.gamemode1;

import nappydevelopment.nappyTheIngenious.data.settings.Language;
import nappydevelopment.nappyTheIngenious.exception.CantFinishGameMode;
import nappydevelopment.nappyTheIngenious.exception.GameHasFinished;
import nappydevelopment.nappyTheIngenious.exception.NoActiveQuestion;
import nappydevelopment.nappyTheIngenious.exception.NoMoreQuestions;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;

public class GM1ActiveStateTest{
	private GameMode1 gm1;
	private String question;

	@Before
	public void init() throws NoMoreQuestions, GameHasFinished{
		gm1 = new GameMode1(Language.values()[0]);
		question = gm1.getQuestion();
	}

	@Test
	public void setAnswerNull() throws GameHasFinished, NoActiveQuestion{
		gm1.setAnswer(null);
	}

	@Test(expected = CantFinishGameMode.class)
	public void endGame() throws CantFinishGameMode, GameHasFinished{
		gm1.endGame();
	}

	@Test
	public void getNumDunno(){
		gm1.getNumDunno();
	}

	@Test
	public void getSureness() throws GameHasFinished{
		gm1.getSureness();
	}

	@Test
	public void isSure(){
		gm1.isSure();
	}

	@Test
	public void isFinished(){
		assertFalse(gm1.isFinished());
	}
}