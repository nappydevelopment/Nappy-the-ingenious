package nappydevelopment.nappyTheIngenious.gamemodes;

import nappydevelopment.nappyTheIngenious.data.Answer;
import nappydevelopment.nappyTheIngenious.data.Sureness;
import nappydevelopment.nappyTheIngenious.data.settings.Language;
import nappydevelopment.nappyTheIngenious.gamemodes.gamemode1.GameMode1;
import nappydevelopment.nappyTheIngenious.gamemodes.gamemode2.GameMode2;
import org.junit.Assert;
import org.junit.Test;

public class VersusTest{
	@Test
	public void GM1VsGM2() throws Exception{
		Language lang = Language.ENGLISH;
		GameMode1 gm1= new GameMode1(lang);
		GameMode2 gm2= new GameMode2(lang);

		while(gm1.isSure() == Sureness.UNSURE){
			String question = gm1.getQuestion();
			Answer ans = gm2.askQuestion(question);
			gm1.setAnswer(ans);
		}
		Assert.assertEquals(gm2.endGame(), gm1.endGame());
	}
}
