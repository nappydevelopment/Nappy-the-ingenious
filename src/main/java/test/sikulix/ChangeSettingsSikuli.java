package test.sikulix;

import org.sikuli.basics.Debug;
import org.sikuli.script.*;

/**
 * Created by mincekara on 05.11.2015.
 */
public class ChangeSettingsSikuli {
    public static void main(String[] args) {
        Debug.setDebugLevel(3);
        Screen s = new Screen();
        Scenario1(s);
        Scenario2(s);
        Scenario3(s);
        Scenario4(s);
        Scenario5(s);
        Scenario6(s);
        Scenario7(s);
    }

    //Scenario1: The User opens the Settings in the menu: Spiel
    private static void Scenario1(Screen s){
        try{
            s.exists("/res/test/images/menu.png");
            s.click("/res/test/images/menu_spiel_button.png");
            s.exists("/res/test/images/menu_spiel.png");
            s.click("/res/test/images/settings_menu.png");
            s.exists("/res/test/images/settings_title.png");
        }
        catch(FindFailed e){
            e.printStackTrace();
        }
    }

    //Scenario2: The User changes the language to German
    private static void Scenario2(Screen s){
        try{
            s.exists("/res/test/images/settings_title.png");
            s.click("/res/test/images/settings_menu.png");
        }
        catch(FindFailed e){
            e.printStackTrace();
        }
    }

    //Scenario3: The User changes the language to English
    private static void Scenario3(Screen s){
        try{
            s.exists("/res/test/images/settings_title.png");
            s.click("/res/test/images/settings_menu.png");
        }
        catch(FindFailed e){
            e.printStackTrace();
        }
    }

    //Scenario4: The User changes the color-theme to bright
    private static void Scenario4(Screen s){
        try{
            s.exists("/res/test/images/settings_title.png");
            s.click("/res/test/images/settings_menu.png");
        }
        catch(FindFailed e){
            e.printStackTrace();
        }
    }

    //Scenario5: The User changes the color-theme to dark
    private static void Scenario5(Screen s){
        try{
            s.exists("/res/test/images/settings_title.png");
            s.click("/res/test/images/settings_menu.png");
        }
        catch(FindFailed e){
            e.printStackTrace();
        }
    }

    //Scenario6: The User changes the playmode: Play complete game
    private static void Scenario6(Screen s){
        try{
            s.exists("/res/test/images/settings_title.png");
            s.click("/res/test/images/settings_menu.png");
        }
        catch(FindFailed e){
            e.printStackTrace();
        }
    }

    //Scenario7: The User changes the playmode: Play just first Gamemode
    private static void Scenario7(Screen s){
        try{
            s.exists("/res/test/images/settings_title.png");
            s.click("/res/test/images/settings_menu.png");
        }
        catch(FindFailed e){
            e.printStackTrace();
        }
    }
}
