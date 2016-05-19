package nappydevelopment.nappyTheIngenious.util;

import javafx.scene.Node;
import javafx.scene.control.Labeled;
import javafx.stage.Stage;
import org.testfx.framework.junit.ApplicationTest;

import java.util.Optional;
import java.util.Set;

public abstract class Util extends ApplicationTest{
	private final static Util u = new Util(){
		@Override
		public void start(Stage stage) throws Exception{}
	};

	public static void click(String lookup, String content){
		u.clickThing(lookup, content);
	}
	@SuppressWarnings("OptionalGetWithoutIsPresent")
	private void clickThing(String lookup, String content){
		Set<? extends Labeled> things = lookup(lookup).queryAll();
		Optional<?> thing = things.stream()
			.filter(b -> content.equals(b.getText()))
			.findFirst();
		clickOn((Node)thing.get());
	}
}
