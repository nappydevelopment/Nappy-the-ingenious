package nappydevelopment.nappy_the_ingenious.gamemodes.gamemode2;

import nappydevelopment.nappy_the_ingenious.data.CharacterProvider;
import nappydevelopment.nappy_the_ingenious.data.settings.Language;
import nappydevelopment.nappy_the_ingenious.exception.GameHasFinished;
import nappydevelopment.nappy_the_ingenious.exception.InvalidQuestion;
import nappydevelopment.nappy_the_ingenious.exception.NoMoreQuestions;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

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
	public void removeAnsweredQuestions() throws InvalidQuestion, GameHasFinished, NoMoreQuestions{
		List<String> questions = gm.getQuestions();
		int last = questions.size();
		gm.askQuestion(questions.get(0));
		questions = gm.getQuestions();
		assertTrue(questions.size() < last);
	}

	@Test
	public void answeredQuestionCounter() throws GameHasFinished{
		assertEquals(gm.answeredQuestions(), 0);
		gm.makeGuess(gm.getQuestions().get(0));
		assertEquals(gm.answeredQuestions(), 1);
	}

	@Test(expected=InvalidQuestion.class)
	public void answerAlreadyAnsweredQuestion() throws Exception{
		String q = gm.getQuestions().get(0);
		assertNotNull(gm.askQuestion(q));
		assertNull(gm.askQuestion(q));
	}

	@Test(expected=GameHasFinished.class)
	public void askQuestionWhenFinished() throws Exception{
		gm.endGame();
		assertNull(gm.askQuestion("EGAL"));
	}
	@Test
	public void makeGuess() throws GameHasFinished{
		assertFalse(gm_det.makeGuess("Jeff Albertson"));
		assertTrue(gm_det.makeGuess("Eleanor Abernathy"));
		gm_det.endGame();
	}
	@Test(expected=GameHasFinished.class)
	public void makeGuessAfterFinished() throws GameHasFinished{
		gm.endGame();
		gm.makeGuess("EGAL");
	}

	@Test
	public void endGame() throws GameHasFinished{
		assertEquals(
			gm_det.endGame(),
			CharacterProvider.getCharacters().get(0)
		);
	}

	@Test(expected=GameHasFinished.class)
	public void doubleEndGame() throws GameHasFinished{
		assertNotNull(gm.endGame());
		assertNull(gm.endGame());
	}

	@Test
	public void finished() throws GameHasFinished{
		assertFalse(gm.isFinished());
		gm.endGame();
		assertTrue(gm.isFinished());
	}
}
