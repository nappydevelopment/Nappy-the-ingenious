package nappydevelopment.nappyTheIngenious.gamemodes;

import nappydevelopment.nappyTheIngenious.data.Answer;
import nappydevelopment.nappyTheIngenious.data.settings.Language;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuestionTest{
	private final Language lang = Language.values()[0];	// some Language
	private final Answer ans = Answer.values()[0];		// some Answer
	private final Answer ans2 = Answer.values()[1];		// another Answer

	private final Question q = new Question(
		"table",
		"attribute",
		lang,
		"question"
	);

	@Test
	public void answers(){
		assertFalse(q.answered());
		q.setAnswer(ans);
		assertTrue(q.answered());
		q.setAnswer(ans2);
		assertNotEquals(ans2, q.getAnswer());
	}
}
