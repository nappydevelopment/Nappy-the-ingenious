package nappydevelopment.nappyTheIngenious.gui.infoStage;

import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

import java.util.concurrent.TimeoutException;

public class InfoStageTest extends ApplicationTest{
	InfoStageController controller;

	@Override
	public void init() throws TimeoutException{
		controller = new InfoStageController(null);

		FxToolkit.registerStage(() -> {
			controller.initView();
			return controller.view;
		});
	}

	@Override
	public void start(Stage stage){ controller.show(new Stage());}
	@Override
	public void stop(){ controller.view.close(); }

	@Test
	public void blogLink(){
		// this hangs :(
		//Todo: either refactor InfoStageController.openBlogInBrowser()
		// Or mock Desktop.getDesktop()
		// clickOn(controller.view.linkBlog);
	}
	@Test
	public void mailLink(){
		//Todo: same as above
		// clickOn(controller.view.linkMail);
	}

}
