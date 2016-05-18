package nappydevelopment.nappyTheIngenious.gui.settingsStage;

import javafx.scene.Node;
import javafx.scene.control.Labeled;
import javafx.stage.Stage;
import nappydevelopment.nappyTheIngenious.data.settings.Language;
import nappydevelopment.nappyTheIngenious.data.settings.Settings;
import org.junit.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

import java.util.Optional;
import java.util.Set;
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
			return controller.view;
		});
	}
	@Override
	public void start(Stage stage){
		stage.show();
	}
	@Override
	public void stop(){
		controller.view.close();
	}

	@Test
	public void english(){
		Settings.setLanguage(Language.GERMAN);

		click(".radio-button", "Englisch");
		click(".button", "Übernehmen");

		assertEquals(Settings.getLanguage(), Language.ENGLISH);
	}

	@SuppressWarnings("OptionalGetWithoutIsPresent")
	private void click(String lookup, String content){
		Set<? extends Labeled> things = lookup(lookup).queryAll();
		Optional<?> thing = things.stream()
			.filter(b -> content.equals(b.getText()))
			.findFirst();
		clickOn((Node)thing.get());
	}
}
