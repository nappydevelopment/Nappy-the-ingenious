package nappydevelopment.nappyTheIngenious.util.eastereggs;

import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import nappydevelopment.nappyTheIngenious.GlobalReferences;
import nappydevelopment.nappyTheIngenious.data.character.*;
import nappydevelopment.nappyTheIngenious.data.character.Character;
import nappydevelopment.nappyTheIngenious.data.settings.Language;
import nappydevelopment.nappyTheIngenious.gui.wikiStage.WikiStageController;
import nappydevelopment.nappyTheIngenious.util.Utils;

import java.awt.RenderingHints;
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
        Image imgOriginal = new Image(GlobalReferences.IMAGES_PATH + "wiki/nappy_gamemode2_fit_size.png");
        Image img = Utils.getScaledInstance(imgOriginal, 110, 110, RenderingHints.VALUE_INTERPOLATION_BICUBIC, 0.80, true);
        
        nappyList.add(new Character("Homer Simpson", nicknames1, nicknames1, img, Gender.FEMALE, Age.YOUNG));
        return nappyList;
    }


}
