package nappydevelopment.nappyTheIngenious.gui.settingsStage;

import javafx.stage.Stage;
import nappydevelopment.nappyTheIngenious.data.settings.ColorScheme;
import nappydevelopment.nappyTheIngenious.data.settings.GameMode;
import nappydevelopment.nappyTheIngenious.data.settings.Language;
import nappydevelopment.nappyTheIngenious.data.settings.Settings;
import org.junit.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

import java.util.concurrent.TimeoutException;

import static junit.framework.TestCase.assertEquals;

public class SettingsStageViewTest extends ApplicationTest{
	private SettingsStageController controller;
	private Language lang = Language.GERMAN;

	@Override
	public void init() throws TimeoutException{
		controller = new SettingsStageController(null);

		FxToolkit.registerStage(() -> {
			controller.initView();
			controller.changeLanguageTo(lang);
			controller.changeThemeToBrightTheme();
			return controller.view;
		});
	}
	@Override
	public void start(Stage stage){ controller.show(new Stage()); }
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

		assertEquals(Language.GERMAN, Settings.getLanguage());
	}

	@Test
	public void setThemeToDark(){
		Settings.setColoScheme(ColorScheme.BRIGHT);

		clickOn(controller.view.rdbDark);
		clickOn(controller.view.btnApply);

		assertEquals(ColorScheme.DARK, Settings.getColoScheme());
	}

	@Test
	public void setThemeToBright(){
		Settings.setColoScheme(ColorScheme.DARK);

		clickOn(controller.view.rdbBright);
		clickOn(controller.view.btnApply);

		assertEquals(ColorScheme.BRIGHT, Settings.getColoScheme());
	}

	@Test
	public void playFirstGameMode(){
		Settings.setGameMode(GameMode.BOTH_MODES);

		clickOn(controller.view.rdbOnlyMode1);
		clickOn(controller.view.btnApply);

		assertEquals(GameMode.ONLY_MODE1, Settings.getGameMode());
	}

	@Test
	public void playBothGameModes(){
		Settings.setGameMode(GameMode.ONLY_MODE1);

		clickOn(controller.view.rdbBothModes);
		clickOn(controller.view.btnApply);

		assertEquals(GameMode.BOTH_MODES, Settings.getGameMode());
	}
}
