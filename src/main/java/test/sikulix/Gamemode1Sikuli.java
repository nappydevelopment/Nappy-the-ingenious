package test.sikulix;

import org.sikuli.basics.Debug;
import org.sikuli.script.*;

/**
 * Created by mincekara on 05.11.2015.
 */
public class Gamemode1Sikuli {
    public static void main(String[] args) {
        Debug.setDebugLevel(3);
        Screen s = new Screen();
        //Scenario1(s);
        Scenario2(s);
        //Scenario3(s);
        Scenario4(s);
        //Scenario5(s);
    }

    //Scenario 1: Open gamemode 1 on the mainscreen
    public static void Scenario1(Screen s){
        try{
            s.exists("/res/test/images/mainstage.png");
            s.exists("/res/test/images/icon.png");
            s.click("/res/test/images/main_newgame_button.png");
            s.exists("/res/test/images/gamemode1_buttons.png");
        }
        catch(FindFailed e){
            e.printStackTrace();
        }
    }

    //Scenario 2: Open gamemode 1 on the menu "Spiel"
    public static void Scenario2(Screen s){
        try{
            s.exists("/res/test/images/menu.png");
            s.click("/res/test/images/menu_spiel_button.png");
            s.exists("/res/test/images/menu_spiel.png");
            s.click("/res/test/images/menu_spiel_newgame_button.png");
            s.exists("/res/test/images/gamemode1_buttons.png");
        }
        catch(FindFailed e){
            e.printStackTrace();
        }
    }

    //Scenario 3: Play second game
    public static void Scenario3(Screen s){
        //do (klick ja, nein, etc) while (endscreen mit erraten)
        try {
            s.exists("/res/test/images/gamemode1_buttons.png");
            s.click("/res/test/images/menu_spiel_button.png");
        }
        catch (FindFailed e){

        }
    }

    //Scenario 4: cancel gamemode1
    public static void Scenario4(Screen s){
        try {
            s.exists("/res/test/images/gamemode1_buttons.png");
            s.exists("/res/test/images/menu.png");
            s.click("/res/test/images/menu_spiel_button.png");
            s.exists("/res/test/images/menu_spiel.png");
            s.click("/res/test/images/menu_spiel_abbruch_button.png");
            s.exists("/res/test/images/cancel_game_dialog.png");
            s.click("/res/test/images/cancel_game_yes_button");
            s.exists("/res/test/images/mainstage.png");
        }
        catch (FindFailed e){

        }
    }

    //Scenario 5: finish gamemode1
    public static void Scenario5(Screen s){

    }
}
