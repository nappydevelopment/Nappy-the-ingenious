package nappydevelopment.nappy_the_ingenious;

//### IMPORTS ##############################################################################################################################
import java.io.File;

public class GlobalReferences {

//### PUBLIC CONSTANTS #####################################################################################################################
   
	public static final String ICONS_PATH = "/main/icons/";
    public static final String IMAGES_PATH = "/main/images/";
    public static final String HTML_PATH = new File(new File("").getAbsolutePath() + "\\src\\main\\html\\").toURI().toString();
    public static final String FONTS_PATH = new File(new File("").getAbsolutePath() + "\\res\\main\\fonts\\").toURI().toString();    
    
}
//### EOF ##################################################################################################################################