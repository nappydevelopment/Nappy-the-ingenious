package test.sikulix;

import org.sikuli.basics.Debug;
import org.sikuli.script.*;

/**
 * Created by mincekara on 05.11.2015.
 */
public class ChangeSettingsSikuli {
    private static final String TEST_IMAGES_PATH = "res/test/images/";

    public static void main(String[] args) {
        Debug.setDebugLevel(3);
        Screen s = new Screen();
        Scenario1(s);
        //Scenario2(s);
        Scenario3(s);
        //Scenario4(s);
        //Scenario5(s);
        //Scenario6(s);
        //Scenario7(s);
    }

    //Scenario1: The user opens the settings with the button in the menu "Spiel"
    private static void Scenario1(Screen s){
        try {
            s.exists(TEST_IMAGES_PATH + "main.png");
            s.exists(TEST_IMAGES_PATH + "icon.png");
            s.click(TEST_IMAGES_PATH + "menu_btn_game.png");
            s.exists(TEST_IMAGES_PATH + "menu_game.png");
            s.click(TEST_IMAGES_PATH + "menu_btn_settings.png");
            s.exists(TEST_IMAGES_PATH + "settings_title.png");
        }catch (FindFailed e){
            e.printStackTrace();
        }
    }

    //Scenario2: The User changes the language to German
    private static void Scenario2(Screen s){
        try {
            s.exists(TEST_IMAGES_PATH + "settings_title.png");
            s.click(TEST_IMAGES_PATH + "settings_opt_de.png");
            s.click(TEST_IMAGES_PATH + "settings_btn_apply.png");
            s.exists(TEST_IMAGES_PATH + "main_en.png");
        }catch (FindFailed e){
            e.printStackTrace();
        }
    }

    //Scenario3: The User changes the language to English
    private static void Scenario3(Screen s){
        try {
            s.exists(TEST_IMAGES_PATH + "settings_title.png");
            s.click(TEST_IMAGES_PATH + "settings_opt_en.png");
            s.click(TEST_IMAGES_PATH + "settings_btn_apply.png");
            s.exists(TEST_IMAGES_PATH + "main.png");
        }catch (FindFailed e){
            e.printStackTrace();
        }
    }

    //Scenario4: The User changes the color-theme to bright
    private static void Scenario4(Screen s){
        try {
            s.exists(TEST_IMAGES_PATH + "settings_title.png");
            s.click(TEST_IMAGES_PATH + "settings_opt_bright.png");
            s.click(TEST_IMAGES_PATH + "settings_btn_apply.png");
            s.exists(TEST_IMAGES_PATH + "main.png");
        }catch (FindFailed e){
            e.printStackTrace();
        }
    }

    //Scenario5: The User changes the color-theme to dark
    private static void Scenario5(Screen s){
        try {
            s.exists(TEST_IMAGES_PATH + "settings_title.png");
            s.click(TEST_IMAGES_PATH + "settings_opt_dark.png");
            s.click(TEST_IMAGES_PATH + "settings_btn_apply.png");
            //s.exists(main_dark)
        }catch (FindFailed e){
            e.printStackTrace();
        }
    }

    //Scenario6: The User changes the playmode: Play complete game
    private static void Scenario6(Screen s){
        //next Semester
    }

    //Scenario7: The User changes the playmode: Play just first Gamemode
    private static void Scenario7(Screen s){
        //next Semester
    }
}
