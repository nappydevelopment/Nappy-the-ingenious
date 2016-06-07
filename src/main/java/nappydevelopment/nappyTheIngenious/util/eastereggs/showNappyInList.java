package nappydevelopment.nappyTheIngenious.util.eastereggs;

import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import nappydevelopment.nappyTheIngenious.data.character.*;
import nappydevelopment.nappyTheIngenious.data.character.Character;
import nappydevelopment.nappyTheIngenious.data.settings.Language;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Marc on 30.05.2016.
 */
public class ShowNappyInList {


        Alert alert;
        private final Map<Language, String> nicknames1 = new HashMap<>();

    public Alert getAlert() {
        return alert;
    }

    public List<Character> getThem(List<Character> list, CharacterFilter search) {
        List<Character> nappyList = new ArrayList<Character>();

        nicknames1.put(Language.GERMAN, "nickname");


        Image img = new CharacterImage("lisa simpson").get();
        nappyList.add(new Character("Nappy the Ingenious", nicknames1, nicknames1, img, Gender.FEMALE, Age.YOUNG));

        return (List<Character>) nappyList;
    }


}
