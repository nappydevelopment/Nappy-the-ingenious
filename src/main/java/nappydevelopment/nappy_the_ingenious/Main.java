package nappydevelopment.nappy_the_ingenious;

//### IMPORTS ##############################################################################################################################
import javafx.application.Application;
import java.io.File;

public class Main {

//### PUBLIC CONSTANTS #####################################################################################################################
   
	public static final String ICONS_PATH = "/main/icons/";
    public static final String IMAGES_PATH = "/main/images/";
    public static final String HTML_PATH = new File(new File("").getAbsolutePath() + "\\src\\main\\html\\").toURI().toString();
    public static final String FONTS_PATH = new File(new File("").getAbsolutePath() + "\\res\\main\\fonts\\").toURI().toString();

//### STATIC ATTRIBUTES ####################################################################################################################
    
    private static GUI gui = new GUI();
    private static Controller controller = new Controller();
    
//### PUBLIC METHODS #######################################################################################################################
    
    //Main-method:
    public static void main(String[] args) {
    	
    	//Set the reference to the controller: 
    	Main.gui.setController(Main.controller);
    	
    	//Start JavaFX-Platform with the JavaFX-Application class gui:
    	Application.launch(gui.getClass(), args);
    }


}
//### EOF ##################################################################################################################################