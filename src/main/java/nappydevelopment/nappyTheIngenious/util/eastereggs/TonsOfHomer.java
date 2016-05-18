package nappydevelopment.nappyTheIngenious.util.eastereggs;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import nappydevelopment.nappyTheIngenious.data.character.Character;
import nappydevelopment.nappyTheIngenious.data.character.CharacterFilter;
import nappydevelopment.nappyTheIngenious.data.settings.ColorScheme;
import nappydevelopment.nappyTheIngenious.data.settings.Settings;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Marc on 13.05.2016.
 */
public class TonsOfHomer {

    public static List<Character> getThem(List<Character> list, CharacterFilter search, List<Character> out) {
        showDohDialog();
        new SoundPlayer("doh");
        List<Character> charList = list.stream()
                .filter(c -> {
                    if(search.getSearchStr().isEmpty()){return true;}
                    return c.getName().toLowerCase().contains("homer");
                }).collect(Collectors.toList());
        for(int i = 0; i < 8; i++){
            out.add(charList.get(0));
        }
        return out;
    }

    private static void showDohDialog() {

        //Create dialog:
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        //Create the dialog buttons:
        ButtonType bttApply = new ButtonType("D'oh!");
        ButtonType bttCancel = new ButtonType("D'oh!");

        //Set properties of the dialog:
        alert.setTitle("D'oh!");

        alert.setHeaderText("D'oh! Something went wrong!");
        alert.getButtonTypes().setAll(bttApply, bttCancel);

        if(Settings.getColoScheme() == ColorScheme.DARK) {
            alert.getDialogPane().getStylesheets().clear();
            alert.getDialogPane().getStylesheets().add("/nappydevelopment/nappyTheIngenious/gui/globalStyle/DarkTheme.css");
        }
    alert.showAndWait();


    }

}
