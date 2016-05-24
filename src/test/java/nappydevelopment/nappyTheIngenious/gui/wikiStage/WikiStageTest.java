package nappydevelopment.nappyTheIngenious.gui.wikiStage;

import javafx.scene.Node;
import javafx.scene.control.Labeled;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import nappydevelopment.nappyTheIngenious.data.character.Age;
import nappydevelopment.nappyTheIngenious.data.character.Character;
import nappydevelopment.nappyTheIngenious.data.character.CharacterImage;
import nappydevelopment.nappyTheIngenious.data.character.Gender;
import nappydevelopment.nappyTheIngenious.data.settings.ColorScheme;
import nappydevelopment.nappyTheIngenious.data.settings.Language;
import nappydevelopment.nappyTheIngenious.data.settings.Settings;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

import java.util.*;
import java.util.concurrent.TimeoutException;

import static org.junit.Assert.*;

public class WikiStageTest extends ApplicationTest{
	private final WikiStageController controller = new WikiStageController(null);
	private static final Language lang = Language.GERMAN;

	private final List<Character> chars = new ArrayList();
	private final Map<Language, String> nicknames1 = new HashMap<>();
	private final Map<Language, String> nicknames2 = new HashMap<>();
	private final Map<Language, String> nicknames3 = new HashMap<>();

	@Override
	public void init() throws TimeoutException{
		nicknames1.put(Language.GERMAN, "nickname");
		nicknames2.put(Language.GERMAN, "");
		nicknames3.put(Language.GERMAN, null);

		Image img = new CharacterImage("lisa simpson").get();
		chars.add(new Character("lisa simpson", nicknames1, nicknames1, img, Gender.FEMALE, Age.YOUNG));
		chars.add(new Character("homer simpson", nicknames2, nicknames2, img, Gender.MALE, Age.ADULT));
		chars.add(new Character("Burns", nicknames3, nicknames3, img, Gender.MALE, Age.OLD));

		FxToolkit.registerStage(() -> {
			controller.initView(chars);
			controller.applySettings();
			return controller.view;
		});
	}
	@Override
	public void start(Stage stage){ controller.show(new Stage()); }
	@Override
	public void stop(){
		controller.view.close();

		// reshow for more coverage
		controller.show(new Stage());
		controller.view.close();
	}

	@BeforeClass
	public static void setLanguage(){
		Settings.setLanguage(lang);
	}

	@Test
	public void testThemes(){
		Settings.setColoScheme(ColorScheme.BRIGHT);
		controller.applySettings();
		Settings.setColoScheme(ColorScheme.DARK);
		controller.applySettings();
	}

	@Test
	public void filterOld(){
		clickOn(controller.view.rbtOld);
		Set<Node> lbl = controller.view.vbxContentPane.lookupAll(".lblName");
		assertEquals(1, lbl.size());
		assertEquals("Burns", ((Labeled)lbl.toArray()[0]).getText());
	}
	@Test
	public void filterYoungFemale(){
		clickOn(controller.view.rbtYoung);
		clickOn(controller.view.rbtFemale);
		Set<Node> lbl = controller.view.vbxContentPane.lookupAll(".lblName");
		assertEquals(1, lbl.size());
		assertEquals("lisa simpson (nickname)", ((Labeled)lbl.toArray()[0]).getText());
	}
	@Test
	public void filterEmpty(){
		clickOn(controller.view.rbtOld);
		clickOn(controller.view.rbtFemale);
		assertTrue(controller.view.vbxContentPane.getChildrenUnmodifiable().isEmpty());
	}
	@Test
	public void search(){
		clickOn(controller.view.txfSearchField);
		write("simpson");
		Set<Node> lbl = controller.view.vbxContentPane.lookupAll(".lblName");
		assertEquals(2, lbl.size());
		clickOn(controller.view.rbtMiddle);
		assertEquals("homer simpson", ((Labeled)lbl.toArray()[0]).getText());
	}
	@Test
	public void resetAge(){
		clickOn(controller.view.rbtMiddle);
		clickOn(controller.view.btnResetFilter);
		assertFalse(controller.view.rbtMiddle.isPressed());
	}
	@Test
	public void resetGender(){
		clickOn(controller.view.rbtMale);
		clickOn(controller.view.btnResetFilter);
		assertFalse(controller.view.rbtMale.isPressed());
	}
}
