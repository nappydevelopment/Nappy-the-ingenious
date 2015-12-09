//### WikiCharacter.java ###################################################################################################################
package nappydevelopment.nappy_the_ingenious.data;

//### IMPORTS ##############################################################################################################################
import javafx.scene.image.Image;

public class WikiCharacter {
	
//### ATTRIBUTES ###########################################################################################################################
	
	private String name;
	private String nickname;
	private String description;
	private String description_de;
	private String description_en;
	private Image wikiImage;

//### CONSTRUCTORS #########################################################################################################################
	
	public WikiCharacter(String name, String nickname, String description, Image wikiImage) {
		this.name = name;
		this.nickname = nickname;
		this.description = description;
		this.wikiImage = wikiImage;
	}
	public WikiCharacter(String name, String nickname, String description_de, String description_en, Image wikiImage) {
		this.name = name;
		this.nickname = nickname;
		this.description = description_de;
		this.description_de = description_de;
		this.description_en = description_en;
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
	public String getDescription_de() {
		return description_de;
	}
	public String getDescription_en() {	return description_en; }

	public Image getWikiImage() {
		return wikiImage;
	}

	@Override
	public String toString(){
		return this.name;
	}
}
//### EOF ##################################################################################################################################