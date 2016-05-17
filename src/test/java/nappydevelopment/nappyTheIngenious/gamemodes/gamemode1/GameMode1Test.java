package nappydevelopment.nappyTheIngenious.gamemodes.gamemode1;

import nappydevelopment.nappyTheIngenious.data.Answer;
import nappydevelopment.nappyTheIngenious.data.Sureness;
import nappydevelopment.nappyTheIngenious.data.settings.Language;
import nappydevelopment.nappyTheIngenious.exception.CantFinishGamemMode;
import nappydevelopment.nappyTheIngenious.exception.GameHasFinished;
import nappydevelopment.nappyTheIngenious.exception.NoActiveQuestion;
import nappydevelopment.nappyTheIngenious.exception.NoMoreQuestions;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameMode1Test{
	private GameMode1 gm;
	private Language lang = Language.GERMAN;

	@Before
	public void init(){
		gm = new GameMode1(lang);
	}

	@Test
	public void finished(){
		assertFalse(gm.isFinished());
	}

	@Test
	public void getCharacterSure() throws Exception{
		while(gm.isSure() == Sureness.UNSURE || gm.isSure() == Sureness.DONTKNOW){
			gm.getQuestion(true);
			gm.setAnswer(Answer.YES);
		}
		assertNotNull(gm.endGame());
	}

	@Test
	public void sureness() throws Exception{
		float sureness = gm.getSureness();
		gm.getQuestion();
		gm.setAnswer(Answer.YES);
		assertTrue(sureness < gm.getSureness());
	}

	@Test
	public void isActive() throws Exception{
		assertFalse(gm.isActive());
		gm.getQuestion();
		assertTrue(gm.isActive());
		gm.setAnswer(Answer.YES);
		assertFalse(gm.isActive());
	}

	@Test
	public void dunnoCount() throws Exception{
		assertEquals(gm.getNumDunno(), 0);

		gm.getQuestion();
		gm.setAnswer(Answer.DONT_KNOW);
		assertEquals(gm.getNumDunno(), 1);

		gm.getQuestion();
		gm.setAnswer(Answer.YES);
		assertEquals(gm.getNumDunno(), 1);

		gm.getQuestion();
		gm.setAnswer(Answer.DONT_KNOW);
		assertEquals(gm.getNumDunno(), 2);
	}

	@Test(expected=NoMoreQuestions.class)
	public void exhaustQuestions() throws Exception{
		finishGM1(gm, Answer.DONT_KNOW);
		gm.getQuestion();
	}

	@Test
	public void getQuestionTwice() throws NoMoreQuestions, GameHasFinished{
		assertEquals(gm.getQuestion(), gm.getQuestion());
	}

	@Test(expected=CantFinishGamemMode.class)
	public void cantFinish() throws CantFinishGamemMode, GameHasFinished{
		gm.endGame();
	}


	@Test
	public void getNumDunnoAfterFinish() throws GameHasFinished, NoActiveQuestion, NoMoreQuestions, CantFinishGamemMode{
		gm.getQuestion();
		gm.setAnswer(Answer.DONT_KNOW);
		finishGM1(gm, Answer.YES);
		gm.endGame();
		assertEquals(gm.getNumDunno(), 1);
	}
	@Test
	public void isSureAfterFinish() throws GameHasFinished, NoMoreQuestions, NoActiveQuestion, CantFinishGamemMode{
		finishGM1(gm, Answer.YES);
		Sureness sure = gm.isSure();
		gm.endGame();
		assertEquals(gm.isSure(), sure);
	}
	@Test
	public void isActiveAfterFinish() throws GameHasFinished, NoMoreQuestions, NoActiveQuestion, CantFinishGamemMode{
		finishGM1(gm, Answer.NO);
		gm.endGame();
		assertEquals(gm.isActive(), false);
	}
	@Test
	public void isFinishedAfterFinish() throws GameHasFinished, NoMoreQuestions, NoActiveQuestion, CantFinishGamemMode{
		finishGM1(gm, Answer.YES);
		gm.endGame();
		assertEquals(gm.isFinished(), true);
	}
	@Test(expected=GameHasFinished.class)
	public void endGameAfterFinish() throws GameHasFinished, NoMoreQuestions, NoActiveQuestion, CantFinishGamemMode{
		finishGM1(gm, Answer.YES);
		gm.endGame();
		gm.endGame();
	}
	@Test(expected=GameHasFinished.class)
	public void setAnswerAfterFinish() throws GameHasFinished, NoActiveQuestion, NoMoreQuestions, CantFinishGamemMode{
		finishGM1(gm, Answer.YES);
		gm.endGame();
		gm.setAnswer(Answer.YES);
	}
	@Test(expected=GameHasFinished.class)
	public void getSurenessAfterFinish() throws GameHasFinished, NoMoreQuestions, NoActiveQuestion, CantFinishGamemMode{
		finishGM1(gm, Answer.YES);
		gm.endGame();
		gm.getSureness();
	}
	@Test(expected=GameHasFinished.class)
	public void getQuestionAfterFinish() throws GameHasFinished, NoMoreQuestions, NoActiveQuestion, CantFinishGamemMode{
		finishGM1(gm, Answer.YES);
		gm.endGame();
		gm.getQuestion();
	}

	private void finishGM1(
		final GameMode1 gm,
		final Answer ans
	)
		throws GameHasFinished,
		NoActiveQuestion,
		NoMoreQuestions
	{
		String q;
		while((q = gm.getQuestion(true)) != null && !q.isEmpty()){
			gm.setAnswer(ans);
		}
	}
}
