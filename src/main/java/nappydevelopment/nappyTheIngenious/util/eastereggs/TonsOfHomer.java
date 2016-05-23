package nappydevelopment.nappyTheIngenious.util.eastereggs;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import nappydevelopment.nappyTheIngenious.data.character.Character;
import nappydevelopment.nappyTheIngenious.data.character.CharacterFilter;
import nappydevelopment.nappyTheIngenious.data.settings.ColorScheme;
import nappydevelopment.nappyTheIngenious.data.settings.Settings;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Marc on 13.05.2016.
 */
public class TonsOfHomer{
    Alert alert;

    public Alert getAlert() {
        return alert;
    }

    public List<Character> getThem(List<Character> list, CharacterFilter search) {
        showDohDialog();
        new SoundPlayer("doh");
        List<Character> homerList = new ArrayList<Character>();
        List<Character> charList = list.stream()
                .filter(c -> {
                    if(search.getSearchStr().isEmpty()){return true;}
                    return c.getName().toLowerCase().contains("homer");
                }).collect(Collectors.toList());
        for(int i = 0; i < 8; i++){
            homerList.add(charList.get(0));
        }
        return (List<Character>)homerList;
    }

    private void showDohDialog() {

        //Create the dialog
        alert = new Alert(Alert.AlertType.CONFIRMATION);

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
