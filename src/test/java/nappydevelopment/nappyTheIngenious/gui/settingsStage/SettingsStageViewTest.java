package nappydevelopment.nappyTheIngenious.gui.settingsStage;

import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

import java.util.Optional;
import java.util.Set;
import java.util.concurrent.TimeoutException;

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
		Set<RadioButton> bla = lookup(".radio-button").queryAll();
		final Optional<RadioButton> first;
		first = bla.stream()
			.filter((RadioButton rb) -> "Englisch".equals(rb.getText()))
			.findFirst();
		clickOn(first.get());
		sleep(800);
	}
}
