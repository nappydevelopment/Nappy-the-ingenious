package nappydevelopment.nappyTheIngenious;

//### IMPORTS ##############################################################################################################################
import java.io.File;

public class GlobalReferences {

//### PUBLIC CONSTANTS #####################################################################################################################
   
	public static final String ICONS_PATH = "icons/";
    public static final String IMAGES_PATH = "images/";
    public static final String CURSORS_PATH = "cursors/";
    public static final String HTML_PATH = new File(new File("").getAbsolutePath() + "\\src\\main\\html\\").toURI().toString();
    public static final String FONTS_PATH = new File(new File("").getAbsolutePath() + "\\res\\main\\fonts\\").toURI().toString();    
    
}
//### EOF ##################################################################################################################################