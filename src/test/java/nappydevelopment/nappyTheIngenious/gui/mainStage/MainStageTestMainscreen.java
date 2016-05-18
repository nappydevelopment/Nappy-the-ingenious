package nappydevelopment.nappyTheIngenious.gui.mainStage;

import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

import java.util.concurrent.TimeoutException;

public class MainStageTestMainscreen extends ApplicationTest{
	private MainStageController controller;

	@Override
	public void init() throws TimeoutException{
		controller = new MainStageController(null);

		FxToolkit.registerStage(() -> {
			controller.initView();
			controller.changeLanguageToGerman();
			controller.showStartView();
			return controller.view;
		});
	}
	@Override
	public void start(Stage stage){ stage.show();}
	@Override
	public void stop(){ controller.view.close(); }

	@Test
	public void startGame(){
		clickOn(controller.view.btnNewGame);
	}

	@Test
	public void help(){
		clickOn(controller.view.btnHelp);
	}

	@Test
	public void openStatistics(){
		clickOn(controller.view.btnStatistic);
	}

	@Test
	public void openWiki(){
		clickOn(controller.view.btnWiki);
	}
}
