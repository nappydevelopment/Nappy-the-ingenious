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

public class NappyInList {

    public List<Character> getThem(List<Character> list, CharacterFilter search) {
        final List<Character> nappyList = new ArrayList<Character>();
        final Map<Language, String> description = new HashMap<>();
        description.put(
            Language.GERMAN,
            "Nappy ist ein Genie in allen Fragen, die die Simpsons betreffen! \r\n " +
            "Er kennt alle Charaktere der Serie und ist in der Lage, diesee anhand einfacher \"Ja-Nein\" Fragen zu erraten.\r\n" +
            "Sein unermessliches Wissen bezieht dieser clevere Kopf über die Windel, welche sein Haupt ziert. \r\n" +
            "Sie ist sein Ein und Alles. Er zieht seine Windel niemals aus und wird dies auch in Zukunft nicht tun. \r\n" +
            "Somit wird es schwierig, ihn überhaupt zu schlagen!\r\n" +
            "Bist du in der Lage Nappy zu schlagen? Dann versuch doch dein Glück!"
        );
        description.put(
            Language.ENGLISH,
            "Nappy is a genius in everything related to the Simpsons! \r\n" +
            "He knows every character from the series and can guess them, by simply asking \"yes\" and \"no\" questions.\r\n" +
            "His immense knowledge relates to the diaper, which decorates his head.\r\n" +
            "It is his everything. He never pulls his diaper from his head and will not do so in the future. \r\n" +
            "Thus, it is difficult to beat him at all!\r\n" +
            "Are you able to beat Nappy? Then try your luck right now!"
        );
        Image img = new CharacterImage("nappy_the_ingenious").get();
        //Image(GlobalReferences.IMAGES_PATH + "general/nappy_gamemode2_fit_size.png");
        nappyList.add(new Character("Nappy the ingenious",new HashMap<Language, String>(), description, img, Gender.FEMALE, Age.YOUNG));
        return nappyList;
    }


}
