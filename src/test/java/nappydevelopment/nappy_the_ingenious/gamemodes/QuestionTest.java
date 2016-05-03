package nappydevelopment.nappy_the_ingenious.gamemodes;

import nappydevelopment.nappy_the_ingenious.data.Answer;
import nappydevelopment.nappy_the_ingenious.data.settings.Language;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuestionTest{
	private Language lang = Language.values()[0];	// some Language
	private Answer ans = Answer.values()[0];		// some Answer
	private Answer ans2 = Answer.values()[1];		// another Answer

	private Question q = new Question(
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
