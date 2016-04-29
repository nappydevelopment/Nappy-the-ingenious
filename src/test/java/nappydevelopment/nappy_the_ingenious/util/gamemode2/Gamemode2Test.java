package nappydevelopment.nappy_the_ingenious.util.gamemode2;

import nappydevelopment.nappy_the_ingenious.data.CharacterProvider;
import nappydevelopment.nappy_the_ingenious.data.settings.Language;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Gamemode2Test{
	private Gamemode2 gm;
	private Gamemode2 gm_det;

	@Before
	public void init(){
		gm = new Gamemode2(Language.GERMAN);
		gm_det = new Gamemode2(Language.GERMAN, true);
	}

	@Test
	public void answeredQuestionCounter(){
		assertEquals(gm.answeredQuestions(), 0);
		gm.makeGuess(gm.getQuestions().get(0));
		assertEquals(gm.answeredQuestions(), 1);
	}

	@Test
	public void answerAlreadyAnsweredQuestion(){
		String q = gm.getQuestions().get(0);
		assertNotNull(gm.askQuestion(q));
		assertNull(gm.askQuestion(q));
	}

	@Test
	public void askQuestionWhenFinished(){
		gm.endGame();
		assertNull(gm.askQuestion("EGAL"));
	}
	@Test
	public void makeGuess(){
		assertFalse(gm_det.makeGuess("Jeff Albertson"));
		assertTrue(gm_det.makeGuess("Eleanor Abernathy"));
		gm_det.endGame();
		assertNull(gm_det.makeGuess("EGAL"));

		gm_det.makeGuess(CharacterProvider.getCharacters().get(0));
	}

	@Test
	public void endGame(){
		assertEquals(
			gm_det.endGame(),
			CharacterProvider.getCharacters().get(0)
		);
	}

	@Test
	public void doubleEndGame(){
		assertNotNull(gm.endGame());
		assertNull(gm.endGame());
	}

	@Test
	public void finished(){
		assertFalse(gm.finished());
		gm.endGame();
		assertTrue(gm.finished());
	}
}
