package nappydevelopment.nappyTheIngenious.util.eastereggs;

import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import nappydevelopment.nappyTheIngenious.GlobalReferences;
import nappydevelopment.nappyTheIngenious.data.character.*;
import nappydevelopment.nappyTheIngenious.data.character.Character;
import nappydevelopment.nappyTheIngenious.data.settings.Language;
import nappydevelopment.nappyTheIngenious.gui.wikiStage.WikiStageController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Marc on 30.05.2016.
 */
public class NappyInList {


    private final Map<Language, String> nicknames1 = new HashMap<>();


    public List<Character> getThem(List<Character> list, CharacterFilter search) {
        List<Character> nappyList = new ArrayList<Character>();
        nicknames1.put(Language.GERMAN, "nickname");
        Image img = new CharacterImage("nappy_the_ingenious").get();
        //Image(GlobalReferences.IMAGES_PATH + "general/nappy_gamemode2_fit_size.png");
        nappyList.add(new Character("Nappy the ingenious", nicknames1, nicknames1, img, Gender.FEMALE, Age.YOUNG));
        return nappyList;
    }


}
