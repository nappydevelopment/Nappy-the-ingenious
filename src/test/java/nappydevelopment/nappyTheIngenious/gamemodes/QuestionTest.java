package nappydevelopment.nappyTheIngenious.gamemodes;

import nappydevelopment.nappyTheIngenious.data.Answer;
import nappydevelopment.nappyTheIngenious.data.settings.Language;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuestionTest{
	private final Language lang = Language.values()[0];	// some Language
	private final Answer ans = Answer.values()[0];		// some Answer
	private final Answer ans2 = Answer.values()[1];		// another Answer

	private Question q1;
	private Question q2;

	private Question qBool1;
	private Question qBool2;

	@Before
	public void init(){
		q1 = new Question(
				"table",
				"attribute",
				lang,
				"question"
		);
		q2 = new Question(
				"table",
				"attribute",
				lang,
				"question"
		);

		qBool1 = new Question(
				"table",
				"TRUE",
				lang,
				"question"
		);
		qBool2 = new Question(
				"table",
				"TRUE",
				lang,
				"question"
		);
	}


	@Test
	public void getLanguage(){
		assertEquals(q1.getLanguage(), lang);
	}

	@Test
	public void tryQuestionError(){
		assertEquals(q1.tryQuestion("NOP?!\"E",false), 0, 0);
	}


	@Test
	public void answers(){
		assertFalse(q1.answered());
		q1.setAnswer(ans);
		assertTrue(q1.answered());
		q1.setAnswer(ans2);
		assertNotEquals(ans2, q1.getAnswer());
	}


	@Test
	public void attributeAnsweredYES() throws Exception{
		q1.setAnswer(Answer.YES);
		q2.attributeAnswered(q1);
		assertTrue(q2.answered());
	}
	@Test
	public void attributeAnsweredNO() throws Exception{
		q1.setAnswer(Answer.NO);
		q2.attributeAnswered(q1);
		assertFalse(q2.answered());
	}

	@Test
	public void attributeAnsweredBoolean() throws Exception{
		qBool2.setAnswer(Answer.NO);
		qBool1.attributeAnswered(qBool2);
		assertTrue(qBool1.answered());
	}
}
