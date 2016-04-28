package nappydevelopment.nappy_the_ingenious.util.gamemode2;

import nappydevelopment.nappy_the_ingenious.data.CharacterProvider;
import nappydevelopment.nappy_the_ingenious.data.settings.Language;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Gamemode2Test{
	private Gamemode2 gm;

	@Before
	public void init(){
		gm = new Gamemode2(Language.GERMAN, true);
	}

	@Test
	public void answeredQuestionCounter() throws Exception{
		assertEquals(gm.answeredQuestions(), 0);
		gm.makeGuess(gm.getQuestions().get(0));
		assertEquals(gm.answeredQuestions(), 1);
	}

	@Test
	public void answerAlreadyAnsweredQuestion() throws Exception{
		String q = gm.getQuestions().get(0);
		assertNotNull(gm.askQuestion(q));
		assertNull(gm.askQuestion(q));
	}

	@Test
	public void makeGuess() throws Exception{
		assertFalse(gm.makeGuess("Jeff Albertson"));
		assertTrue(gm.makeGuess("Eleanor Abernathy"));
	}

	@Test
	public void endGame() throws Exception{
		assertEquals(
			gm.endGame(),
			CharacterProvider.getCharacters().get(0)
		);
	}

	@Test
	public void doubleEndGame() throws Exception{
		assertNotNull(gm.endGame());
		assertNull(gm.endGame());
	}
}
