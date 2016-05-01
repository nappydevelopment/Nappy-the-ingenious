package nappydevelopment.nappy_the_ingenious.util.gamemode1;

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
		gm_det = new Gamemode1(true);
		gm = new Gamemode1(false);
	}

	@Test
	public void getCharacterUnsure(){
		assertNull(gm.getCharacter());

		gm.getQuestion(lang);
		gm.setAnswer(null);

		assertNull(gm.getCharacter());
	}
	@Test
	public void getCharacterSure(){
		while(!gm.isSure()){
			gm.getQuestion(lang);
			gm.setAnswer(true);
		}
		assertNotNull(gm.getCharacter());
		assertNull(gm.getQuestion(lang));
	}

	@Test
	public void sureness(){
		float sureness = gm.getSureness();
		gm.getQuestion(lang);
		gm.setAnswer(true);
		assertTrue(sureness < gm.getSureness());
	}

	@Test
	public void isActive(){
		assertFalse(gm.isActive());
		gm.getQuestion(lang);
		assertTrue(gm.isActive());
		gm.setAnswer(true);
		assertFalse(gm.isActive());
	}

	@Test
	public void dunnoCount(){
		assertEquals(gm.getNumDunno(), 0);

		gm.getQuestion(lang);
		gm.setAnswer(null);
		assertEquals(gm.getNumDunno(), 1);

		gm.getQuestion(lang);
		gm.setAnswer(true);
		assertEquals(gm.getNumDunno(), 1);

		gm.getQuestion(lang);
		gm.setAnswer(null);
		assertEquals(gm.getNumDunno(), 2);
	}

	@Test
	public void exhaustQuestions(){
		String q;
		while((q = gm.getQuestion(lang)) != null && !q.isEmpty()){
			gm.setAnswer(null);
		}
		assertNull(gm.getQuestion(lang));
	}

	@Test
	public void impossibleCharacter(){
		System.out.println(gm_det.getQuestion(lang));
		gm_det.setAnswer(false);
		System.out.println(gm_det.getQuestion(lang));
		gm_det.setAnswer(true);
		System.out.println(gm_det.getQuestion(lang));
		gm_det.setAnswer(false);
		System.out.println(gm_det.getQuestion(lang));
		gm_det.setAnswer(true);
		System.out.println(gm_det.getQuestion(lang));
		gm_det.setAnswer(false);
		System.out.println(gm_det.getQuestion(lang));
		gm_det.setAnswer(true);
		System.out.println(gm_det.getQuestion(lang));
		gm_det.setAnswer(true);
		System.out.println(gm_det.getQuestion(lang));
		gm_det.setAnswer(true);
		System.out.println(gm_det.getCharacter());
		System.out.println(gm_det.getSureness());
		//assertNull(gm_det.getCharacter());
		//assertNull(gm_det.isSure());
	}

	@Test
	public void getQuestionTwice(){
		assertEquals(gm.getQuestion(lang), gm.getQuestion(lang));
	}
}
