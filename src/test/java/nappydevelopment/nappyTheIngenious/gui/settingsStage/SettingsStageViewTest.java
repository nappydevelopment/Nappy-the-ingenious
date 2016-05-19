package nappydevelopment.nappyTheIngenious.gui.settingsStage;

import javafx.stage.Stage;
import nappydevelopment.nappyTheIngenious.data.settings.ColorScheme;
import nappydevelopment.nappyTheIngenious.data.settings.Language;
import nappydevelopment.nappyTheIngenious.data.settings.Settings;
import org.junit.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

import java.util.concurrent.TimeoutException;

import static junit.framework.TestCase.assertEquals;

public class SettingsStageViewTest extends ApplicationTest{
	private SettingsStageController controller;
	@Override
	public void init() throws TimeoutException{
		controller = new SettingsStageController(null);

		FxToolkit.registerStage(() -> {
			controller.initView();
			controller.changeLanguageToGerman();
			controller.changeThemeToBrightTheme();
			return controller.view;
		});
	}
	@Override
	public void start(Stage stage){ stage.show(); }
	@Override
	public void stop(){ controller.view.close(); }

	@Test
	public void setLanguageToEnglish(){
		Settings.setLanguage(Language.GERMAN);

		clickOn(controller.view.rdbEnglish);
		clickOn(controller.view.btnApply);

		assertEquals(Language.ENGLISH, Settings.getLanguage());
	}

	@Test
	public void setLanguageToGerman(){
		Settings.setLanguage(Language.ENGLISH);

		clickOn(controller.view.rdbGerman);
		clickOn(controller.view.btnApply);

		assertEquals(Language.ENGLISH, Settings.getLanguage());
	}

	@Test
	public void setThemeToDark(){
		Settings.setColoScheme(ColorScheme.BRIGHT);

		clickOn(controller.view.rdbDark);
		clickOn(controller.view.btnApply);
	}

	@Test
	public void setThemeToBright(){

	}
}
