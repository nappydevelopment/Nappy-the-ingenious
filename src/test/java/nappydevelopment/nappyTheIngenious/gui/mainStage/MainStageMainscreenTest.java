package nappydevelopment.nappyTheIngenious.gui.mainStage;

import javafx.stage.Stage;
import nappydevelopment.nappyTheIngenious.data.settings.Language;
import nappydevelopment.nappyTheIngenious.data.settings.Settings;
import org.junit.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

import java.util.concurrent.TimeoutException;

public class MainStageMainscreenTest extends ApplicationTest{
	private MainStageController controller = new MainStageController(null);
	private Language lang = Language.GERMAN;

	@Override
	public void init() throws TimeoutException{
		Settings.setLanguage(lang);
		FxToolkit.registerStage(() -> {
			controller.initView(null);
			controller.applySettings();
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
	public void openStatistics(){
		clickOn(controller.view.btnStatistic);
	}

	@Test
	public void help(){
		clickOn(controller.view.btnHelp);
	}

	@Test
	public void openWiki(){
		clickOn(controller.view.btnWiki);
	}
}
