package nappydevelopment.nappyTheIngenious.gui.wikiStage;

import javafx.stage.Stage;
import nappydevelopment.nappyTheIngenious.data.settings.Language;
import org.junit.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

import java.util.Collections;
import java.util.concurrent.TimeoutException;

public class WikiStageEasterEggTest extends ApplicationTest{
	private WikiStageController controller;
	private Language lang = Language.GERMAN;

	@Override
	public void init() throws TimeoutException{
		controller = new WikiStageController();

		FxToolkit.registerStage(() -> {
			controller.initView(Collections.emptyList());
			controller.applySettings();
			return controller.view;
		});
	}
	@Override
	public void start(Stage stage){ stage.show(); }
	@Override
	public void stop(){ controller.view.close(); }

	@Test
	public void nelson(){
		clickOn(controller.view.txfSearchField);
		write("haha");
	}
	@Test
	public void nappy(){
		clickOn(controller.view.txfSearchField);
		write("nappy");
	}
	@Test
	public void homer(){
		clickOn(controller.view.txfSearchField);
		write("d'oh");
	}
}
