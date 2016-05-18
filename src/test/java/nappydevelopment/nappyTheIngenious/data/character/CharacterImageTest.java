package nappydevelopment.nappyTheIngenious.data.character;

import org.junit.Test;

public class CharacterImageTest{
	@Test(expected=NullPointerException.class)
	public void error(){
		new CharacterImage(null);
	}
}
