package test.sikulix;

import org.sikuli.basics.Debug;
import org.sikuli.script.*;

/**
 * Created by mincekara on 05.11.2015.
 */
public class ViewStatisticSikuli {
    public static void main(String[] args) {
        Debug.setDebugLevel(3);
        Screen s = new Screen();
        //Scenario1(s);
        Scenario2(s);
        Scenario3(s);
    }

    //Scenario1: The user will open the statistic screen. The user uses the button on the mainscreen
    private static void Scenario1(Screen s){
        try{
            s.exists("/res/test/images/mainstage.png");
            s.exists("/res/test/images/icon.png");
            s.click("/res/test/images/statistic_button.png");
            s.exists("/res/test/images/statistic_title.png");
        }
        catch(FindFailed e){
            e.printStackTrace();
        }
    }

    //Scenario2: The user will open the statistic screen. The user uses the button in the menu: Spiel
    private static void Scenario2(Screen s){
        try{
            s.exists("/res/test/images/menu.png");
            s.click("/res/test/images/menu_spiel_button.png");
            s.exists("/res/test/images/menu_spiel.png");
            s.click("/res/test/images/statistic_menu.png");
            s.exists("/res/test/images/statistic_title.png");
        }
        catch(FindFailed e){
            e.printStackTrace();
        }
    }

    //Scenario3: The user will close the statistic screen
    private static void Scenario3(Screen s){
        try{
            s.exists("/res/test/images/statistic_title.png");
            s.click("/res/test/images/close.png");
            s.exists("/res/test/images/mainstage.png");
        }
        catch(FindFailed e){
            e.printStackTrace();
        }
    }
}
