package nappydevelopment.nappyTheIngenious.gui.wikiStage;

import javafx.scene.image.Image;
import javafx.stage.Stage;
import nappydevelopment.nappyTheIngenious.data.character.Age;
import nappydevelopment.nappyTheIngenious.data.character.Character;
import nappydevelopment.nappyTheIngenious.data.character.CharacterImage;
import nappydevelopment.nappyTheIngenious.data.character.Gender;
import nappydevelopment.nappyTheIngenious.data.settings.Language;
import org.junit.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import static org.junit.Assert.assertEquals;

public class WikiStageTest extends ApplicationTest{
	private WikiStageController controller;
	private Language lang = Language.GERMAN;

	private List<Character> chars = new ArrayList();
	private Map<Language, String> nicknames = new HashMap<>();

	@Override
	public void init() throws TimeoutException{
		nicknames.put(Language.GERMAN, "nickname");

		Image img = new CharacterImage("lisa simpson").get();
		chars.add(new Character("lisa simpson", nicknames, nicknames, img, Gender.FEMALE, Age.YOUNG));
		chars.add(new Character("homer simpson", nicknames, nicknames, img, Gender.MALE, Age.ADULT));
		chars.add(new Character("Burns", nicknames, nicknames, img, Gender.MALE, Age.OLD));

		controller = new WikiStageController();

		FxToolkit.registerStage(() -> {
			controller.initView(chars);
			controller.changeLanguageTo(lang);
			return controller.view;
		});
	}
	@Override
	public void start(Stage stage){ controller.show(new Stage()); }
	@Override
	public void stop(){ controller.view.close(); }

	@Test
	public void filterYoung(){
		clickOn(controller.view.rbtYoung);
		assertEquals(
			controller.view.vbxContentPane.getChildren().get(0).lookup(".lblName"),
			lookup(".lblName").query()
		);
	}
	@Test
	public void filterYoungFemale(){
		clickOn(controller.view.rbtYoung);
		clickOn(controller.view.rbtFemale);
		assertEquals(
			controller.view.vbxContentPane.getChildren().get(0).lookup(".lblName"),
			lookup(".lblName").query()
		);
	}
}
