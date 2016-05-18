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
	public void start(Stage stage){ stage.show();}
	@Override
	public void stop(){ controller.view.close(); }

	@Test
	public void should_drag_file_into_trashcan(){
		sleep(1500);
		// given:
		//rightClickOn("#desktop").moveTo("New").clickOn("Text Document");
		//write("myTextfile.txt").push(ENTER);

		// when:
		//drag(".file").dropTo("#trash-can");

		// then:
		//verifyThat("#desktop", hasChildren(0, ".file"));
	}

}
