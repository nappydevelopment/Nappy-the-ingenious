package nappydevelopment.nappyTheIngenious;

import javafx.stage.Stage;
import nappydevelopment.nappyTheIngenious.data.settings.Language;
import nappydevelopment.nappyTheIngenious.data.settings.Settings;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

public class ProgramTest extends ApplicationTest{
	private static Program p;
	@BeforeClass
	public static void initialize() throws Exception{
		Settings.setLanguage(Language.GERMAN);
		p = new Program();
		p.init();
	}
	@Test
	public void gm1(){
		clickOn("Neues Spiel");
		while(lookup("Richtig").queryAll().isEmpty()){
			if(Math.random() >= 0.5){
				clickOn("Ja");
			}else{
				clickOn("Nein");
			}
		}
		clickOn("Richtig");
		Assert.assertEquals(1, lookup("Ja").queryAll().size());
	}

	@Override
	public void start(Stage stage) throws Exception{ p.start(stage); }
	@Override
	public void stop(){ p.stop(); }
}
