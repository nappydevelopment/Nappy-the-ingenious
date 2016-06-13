package nappydevelopment.nappyTheIngenious.gui.wikiStage;

import javafx.scene.image.Image;
import javafx.stage.Stage;
import nappydevelopment.nappyTheIngenious.data.CharacterProvider;
import nappydevelopment.nappyTheIngenious.data.character.Age;
import nappydevelopment.nappyTheIngenious.data.character.Character;
import nappydevelopment.nappyTheIngenious.data.character.CharacterImage;
import nappydevelopment.nappyTheIngenious.data.character.Gender;
import nappydevelopment.nappyTheIngenious.data.settings.Language;
import org.junit.Assert;
import org.junit.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

import java.util.*;
import java.util.concurrent.TimeoutException;

public class WikiStageEasterEggTest extends ApplicationTest{
	private WikiStageController controller;
	private Language lang = Language.GERMAN;

	private final List<Character> chars = new ArrayList();
	private final Map<Language, String> nicknames1 = new HashMap<>();


	@Override
	public void init() throws TimeoutException{
		controller = new WikiStageController(null);

		nicknames1.put(Language.GERMAN, "nickname");

		Image img = new CharacterImage("homer simpson").get();
		chars.add(new Character("homer simpson", nicknames1, nicknames1, img, Gender.FEMALE, Age.YOUNG));
		Image img1 = new CharacterImage("nelson muntz").get();
		chars.add(new Character("nelson muntz", nicknames1, nicknames1, img1, Gender.FEMALE, Age.YOUNG));

		FxToolkit.registerStage(() -> {
			controller.initView(chars);
			controller.applySettings();
			return controller.view;
		});
	}
	@Override
	public void start(Stage stage){ stage.show(); }
	@Override
	public void stop(){
		controller.view.close();
		CharacterProvider.getEggs().getNelsonStages().stream().forEach(Stage::close);
		CharacterProvider.getEggs().getNappyStages().stream().forEach(Stage::close);
	}

	@Test
	public void nelson(){
		clickOn(controller.view.txfSearchField);
		write("haha");
		for(int i = 0; i < 7; i++){
			closeCurrentWindow();
		}
		Assert.assertEquals(1, controller.view.vbxContentPane.lookupAll(".lblName").size());

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
		clickOn("D'oh!");
		Assert.assertEquals(8, controller.view.vbxContentPane.lookupAll(".lblName").size());
	}
}
