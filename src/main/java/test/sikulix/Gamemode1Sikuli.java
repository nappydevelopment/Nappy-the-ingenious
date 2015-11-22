package test.sikulix;

import org.sikuli.basics.Debug;
import org.sikuli.script.*;

/**
 * Created by mincekara on 05.11.2015.
 */
public class Gamemode1Sikuli {
    private static final String TEST_IMAGES_PATH = "res/test/images/";

    public static void main(String[] args) {
        Screen s = new Screen();
        //Scenario1(s);
        Scenario2(s);
        //Scenario3(s);
        Scenario4(s);
        //Scenario5(s);
    }

    //Scenario 1: Open gamemode 1 with the button at the mainscreen
    public static void Scenario1(Screen s) {
        try {
            s.exists(TEST_IMAGES_PATH + "main.png");
            s.exists(TEST_IMAGES_PATH + "icon.png");
            s.click(TEST_IMAGES_PATH + "main_btn_new.png");
            s.exists(TEST_IMAGES_PATH + "gamemode1_btns.png");
        }catch(FindFailed e){
            e.printStackTrace();
        }
    }

    //Scenario 2: Open gamemode 1 with the button in the menu "Spiel"
    public static void Scenario2(Screen s){
        try {
            s.exists(TEST_IMAGES_PATH + "main.png");
            s.exists(TEST_IMAGES_PATH + "icon.png");
            s.click(TEST_IMAGES_PATH + "menu_btn_game.png");
            s.exists(TEST_IMAGES_PATH + "menu_game.png");
            s.click(TEST_IMAGES_PATH + "menu_btn_new.png");
            s.exists(TEST_IMAGES_PATH + "gamemode1_btns.png");
        }catch (FindFailed e){
            e.printStackTrace();
        }
    }

    //Scenario 3: Play second game
    public static void Scenario3(Screen s){
        s.exists(TEST_IMAGES_PATH + "gamemode1_btns.png");
        //...
    }

    //Scenario 4: Abort current (active) game
    public static void Scenario4(Screen s){
        try {
            s.exists(TEST_IMAGES_PATH + "gamemode1_btns.png");
            s.exists(TEST_IMAGES_PATH + "menus.png");
            s.click(TEST_IMAGES_PATH + "menu_btn_game.png");
            s.exists(TEST_IMAGES_PATH + "menu_game.png");
            s.click(TEST_IMAGES_PATH + "menu_btn_abort.png");
            s.exists(TEST_IMAGES_PATH + "abort_game_dialog.png");
            s.click(TEST_IMAGES_PATH + "abort_game_btn.png");
            s.exists(TEST_IMAGES_PATH + "main.png");
        }catch (FindFailed e){
            e.printStackTrace();
        }
    }

    //Scenario 5: Finish current game
    public static void Scenario5(Screen s){
        try {
            Scenario3(s);
            s.exists(TEST_IMAGES_PATH + "gamemode1_btns.png");
            s.click(TEST_IMAGES_PATH + "menu_btn_game.png");
            s.exists(TEST_IMAGES_PATH + "main.png");
        }catch (FindFailed e){
            e.printStackTrace();
        }
    }
}
