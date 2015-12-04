//### WikiCharacter.java ###################################################################################################################
package nappydevelopment.nappy_the_ingenious.data;

//### IMPORTS ##############################################################################################################################
import javafx.scene.image.Image;

public class WikiCharacter {
	
//### ATTRIBUTES ###########################################################################################################################
	
	private String name;
	private String nickname;
	private String description;
	private Image wikiImage;

//### CONSTRUCTORS #########################################################################################################################
	
	public WikiCharacter(String name, String nickname, String description, Image wikiImage) {
		this.name = name;
		this.nickname = nickname;
		this.description = description;
		this.wikiImage = wikiImage;
	}
	
//### GETTER/SETTER ########################################################################################################################
	
	public String getName() {
		return name;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public String getDescription() {
		return description;
	}

	public Image getWikiImage() {
		return wikiImage;
	}

	@Override
	public String toString(){
		return this.name;
	}
}
//### EOF ##################################################################################################################################