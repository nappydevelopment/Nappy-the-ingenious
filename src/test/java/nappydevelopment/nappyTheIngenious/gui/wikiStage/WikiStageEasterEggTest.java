package nappydevelopment.nappyTheIngenious.gui.wikiStage;

import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

import java.util.Collections;
import java.util.concurrent.TimeoutException;

public class WikiStageEasterEggTest extends ApplicationTest{
	private WikiStageController controller;

	@Override
	public void init() throws TimeoutException{
		controller = new WikiStageController();

		FxToolkit.registerStage(() -> {
			controller.initView(Collections.emptyList());
			controller.changeLanguageToGerman();
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
