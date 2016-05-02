package nappydevelopment.nappy_the_ingenious.util.gamemode1;

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
		assertNull(gm.getCharacter());

		gm.getQuestion();
		gm.setAnswer(null);

		assertNull(gm.getCharacter());
	}
	@Test
	public void getCharacterSure() throws NoActiveQuestion{
		while(!gm.isSure()){
			gm.getQuestion();
			gm.setAnswer(Answer.YES);
		}
		assertNotNull(gm.getCharacter());
		assertNull(gm.getQuestion());
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
		while((q = gm.getQuestion()) != null && !q.isEmpty()){
			gm.setAnswer(Answer.DONT_KNOW);
		}
		assertNull(gm.getQuestion());
	}

	@Test
	public void impossibleCharacter(){
		//System.out.println(gm_det.getQuestion(lang)); // Ist deine Figur temperamentvoll?
		//gm_det.setAnswer(Answer.NO);
		//System.out.println(gm_det.getQuestion(lang)); // Ist deine Figur ehrlich?
		//gm_det.setAnswer(Answer.YES);
		//System.out.println(gm_det.getQuestion(lang)); // Ist dein Charakter im mittlerem Alter?
		//gm_det.setAnswer(Answer.NO);
		//System.out.println(gm_det.getQuestion(lang)); // Ist deine Figur nervig?
		//gm_det.setAnswer(Answer.YES);
		//System.out.println(gm_det.getQuestion(lang)); // Hat dein Character schwarze Haare?
		//gm_det.setAnswer(Answer.NO);
		//System.out.println(gm_det.getQuestion(lang)); // Ist deine Figur Schüler/Student?
		//gm_det.setAnswer(Answer.YES);
		//assertNull(gm_det.getCharacter());  // rodd & todd

		//assertEquals(0.5, gm_det.getSureness(), 0.001);
	}

	@Test
	public void getQuestionTwice(){
		assertEquals(gm.getQuestion(), gm.getQuestion());
	}
}
