package nappydevelopment.nappyTheIngenious.data.character;

import javafx.scene.image.Image;
import nappydevelopment.nappyTheIngenious.GlobalReferences;


public class CharacterImage{
	private Image img = null;

	public CharacterImage(final String name){
		try{
			new Image(GlobalReferences.IMAGES_PATH + "wiki/" + name.toLowerCase().replace(" ", "_") +".png");
		}catch(RuntimeException e){
			if(!"Internal graphics not initialized yet".equals(e.getMessage())){
				throw e;
			}
		}
	}
	public Image get(){ return img; }
}
