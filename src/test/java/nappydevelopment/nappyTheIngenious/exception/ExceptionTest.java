package nappydevelopment.nappyTheIngenious.exception;

import org.junit.Test;

public class ExceptionTest{

	@Test(expected=CantFinishGameMode.class)
	public void cantFinishGameMode() throws Exception {
		throw new CantFinishGameMode();
	}

	@Test(expected=CouldNotSaveToDatabase.class)
	public void couldNotSaveToDatabase() throws Exception {
		throw new CouldNotSaveToDatabase(new Exception("cause"));
	}

	@Test(expected=GameHasFinished.class)
	public void gameHasFinished() throws Exception {
		throw new GameHasFinished();
	}

	@Test(expected=InvalidQuestion.class)
	public void invalidQuestion() throws Exception {
		throw new InvalidQuestion();
	}

	@Test(expected=NoActiveQuestion.class)
	public void noActiveQuestion() throws Exception {
		throw new NoActiveQuestion();
	}

	@Test(expected=NoMoreQuestions.class)
	public void noMoreQuestions() throws Exception {
		throw new NoMoreQuestions();
	}
}
