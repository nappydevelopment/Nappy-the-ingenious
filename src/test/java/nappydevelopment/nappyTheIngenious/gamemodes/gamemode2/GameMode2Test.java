package nappydevelopment.nappyTheIngenious.gamemodes.gamemode2;

import nappydevelopment.nappyTheIngenious.data.CharacterProvider;
import nappydevelopment.nappyTheIngenious.data.settings.Language;
import nappydevelopment.nappyTheIngenious.exception.GameHasFinished;
import nappydevelopment.nappyTheIngenious.exception.InvalidQuestion;
import nappydevelopment.nappyTheIngenious.exception.NoMoreQuestions;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GameMode2Test{
	private GameMode2 gm;
	private GameMode2 gm_det;

	@Before
	public void init(){
		gm = new GameMode2(Language.GERMAN);
		gm_det = new GameMode2(Language.GERMAN, true);
	}


	@Test
	public void removeAnsweredQuestions()
		throws InvalidQuestion, GameHasFinished, NoMoreQuestions
	{
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

	@Test
	public void makeGuess() throws GameHasFinished{
		assertFalse(gm_det.makeGuess("Jeff Albertson"));
		assertTrue(gm_det.makeGuess("Eleanor Abernathy"));
		gm_det.endGame();
	}

	@Test
	public void endGame() throws GameHasFinished{
		assertEquals(
			gm_det.endGame(),
			CharacterProvider.getCharacters().get(0)
		);
	}

	@Test
	public void finished() throws GameHasFinished{
		assertFalse(gm.isFinished());
	}

	@Test
	public void getQuestionAnswerList() throws GameHasFinished{
		List<String> questions = gm.getQuestions();
		gm.getQuestionAnswerList().forEach(qae -> {
			if(!questions.remove(qae.getQuestion())){
				fail("not all questions in questionAnswerList");
			}
		});
	}
}
