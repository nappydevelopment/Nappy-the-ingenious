package nappydevelopment.nappy_the_ingenious.gamemodes.gamemode1;

import nappydevelopment.nappy_the_ingenious.data.Answer;
import nappydevelopment.nappy_the_ingenious.data.settings.Language;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Gamemode1Test{
	private Gamemode1 gm_det;
	private Gamemode1 gm;
	private Language lang = Language.GERMAN;

	@Before
	public void init(){
		gm_det = new Gamemode1(lang, true);
		gm = new Gamemode1(lang, false);
	}

	@Test
	public void getCharacterUnsure() throws NoActiveQuestion{
		assertNull(gm.endGame());

		gm.getQuestion();
		gm.setAnswer(null);

		assertNull(gm.endGame());
	}
	@Test
	public void getCharacterSure() throws NoActiveQuestion{
		while(!gm_det.isSure()){
			gm_det.getQuestion();
			gm_det.setAnswer(Answer.YES);
		}
		assertNotNull(gm_det.endGame());
		assertNull(gm_det.getQuestion());
	}

	@Test
	public void sureness() throws NoActiveQuestion{
		float sureness = gm.getSureness();
		gm.getQuestion();
		gm.setAnswer(Answer.YES);
		assertTrue(sureness < gm.getSureness());
	}

	@Test
	public void isActive() throws NoActiveQuestion{
		assertFalse(gm.isActive());
		gm.getQuestion();
		assertTrue(gm.isActive());
		gm.setAnswer(Answer.YES);
		assertFalse(gm.isActive());
	}

	@Test
	public void dunnoCount() throws NoActiveQuestion{
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

	@Test
	public void exhaustQuestions() throws NoActiveQuestion{
		String q;
		while((q = gm_det.getQuestion()) != null && !q.isEmpty()){
			gm_det.setAnswer(Answer.DONT_KNOW);
		}
		assertNull(gm_det.getQuestion());
	}

	@Test
	public void getQuestionTwice(){
		assertEquals(gm.getQuestion(), gm.getQuestion());
	}
}
