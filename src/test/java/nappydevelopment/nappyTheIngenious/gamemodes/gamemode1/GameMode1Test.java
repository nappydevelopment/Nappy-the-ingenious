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
	private GameMode1 gm_det;
	private GameMode1 gm;
	private Language lang = Language.GERMAN;

	@Before
	public void init(){
		gm_det = new GameMode1(lang, true);
		gm = new GameMode1(lang);
	}

	@Test
	public void finished(){
		assertFalse(gm.isFinished());
	}

	@Test
	public void getCharacterSure() throws Exception{
		while(gm_det.isSure() == Sureness.UNSURE || gm_det.isSure() == Sureness.DONTKNOW){
			gm_det.getQuestion();
			gm_det.setAnswer(Answer.YES);
		}
		assertNotNull(gm_det.endGame());
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
		finishGM1(gm_det, Answer.DONT_KNOW);
		gm_det.getQuestion();
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
		gm_det.getQuestion();
		gm_det.setAnswer(Answer.DONT_KNOW);
		finishGM1(gm_det, Answer.YES);
		gm_det.endGame();
		assertEquals(gm_det.getNumDunno(), 1);
	}
	@Test
	public void isSureAfterFinish() throws GameHasFinished, NoMoreQuestions, NoActiveQuestion, CantFinishGamemMode{
		finishGM1(gm_det, Answer.YES);
		Sureness sure = gm_det.isSure();
		gm_det.endGame();
		assertEquals(gm_det.isSure(), sure);
	}
	@Test
	public void isActiveAfterFinish() throws GameHasFinished, NoMoreQuestions, NoActiveQuestion, CantFinishGamemMode{
		finishGM1(gm_det, Answer.NO);
		gm_det.endGame();
		assertEquals(gm_det.isActive(), false);
	}
	@Test
	public void isFinishedAfterFinish() throws GameHasFinished, NoMoreQuestions, NoActiveQuestion, CantFinishGamemMode{
		finishGM1(gm_det, Answer.YES);
		gm_det.endGame();
		assertEquals(gm_det.isFinished(), true);
	}
	@Test(expected=GameHasFinished.class)
	public void endGameAfterFinish() throws GameHasFinished, NoMoreQuestions, NoActiveQuestion, CantFinishGamemMode{
		finishGM1(gm_det, Answer.YES);
		gm_det.endGame();
		gm_det.endGame();
	}
	@Test(expected=GameHasFinished.class)
	public void setAnswerAfterFinish() throws GameHasFinished, NoActiveQuestion, NoMoreQuestions, CantFinishGamemMode{
		finishGM1(gm_det, Answer.YES);
		gm_det.endGame();
		gm_det.setAnswer(Answer.YES);
	}
	@Test(expected=GameHasFinished.class)
	public void getSurenessAfterFinish() throws GameHasFinished, NoMoreQuestions, NoActiveQuestion, CantFinishGamemMode{
		finishGM1(gm_det, Answer.YES);
		gm_det.endGame();
		gm_det.getSureness();
	}
	@Test(expected=GameHasFinished.class)
	public void getQuestionAfterFinish() throws GameHasFinished, NoMoreQuestions, NoActiveQuestion, CantFinishGamemMode{
		finishGM1(gm_det, Answer.YES);
		gm_det.endGame();
		gm_det.getQuestion();
	}

	@Test
	public void QuestionLanguage(){

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
		while((q = gm.getQuestion()) != null && !q.isEmpty()){
			gm.setAnswer(ans);
		}
	}
}
