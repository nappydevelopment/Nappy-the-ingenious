package nappydevelopment.nappy_the_ingenious.data;

import javafx.scene.image.Image;
import nappydevelopment.nappy_the_ingenious.data.settings.Language;

import java.util.Map;

public class WikiCharacter {
	private final String name;
	private final Map<Language, String> nicknames;
	private final Map<Language, String> descriptions;
	private final Image wikiImage;
	private final Gender gender;
	private final Age age;


	public WikiCharacter(
			String name,
			Map<Language, String> nicknames,
			Map<Language, String> descriptions,
			Image wikiImage,
			Gender gender,
			Age age
	) {
		this.name = name;
		this.nicknames = nicknames;
		this.wikiImage = wikiImage;
		this.descriptions = descriptions;
		this.gender = gender;
		this.age = age;
	}


	public Gender getGender() {
		return gender;
	}

	public Age getAge() {
		return age;
	}

	public String getName() {return name; }

	public String getNickname(final Language l) { return nicknames.get(l); }
	protected Map<Language, String> getNicknames() { return nicknames; }

	public String getDescription(final Language l) { return descriptions.get(l); }
	protected Map<Language, String> getDescriptions() { return descriptions; }

	public Image getWikiImage() { return wikiImage; }

	@Override
	public String toString() { return this.name; }

	@Override
	public boolean equals(Object obj){
		if((obj instanceof WikiCharacter)){
			WikiCharacter other = (WikiCharacter) obj;
			if(
				this.descriptions.values().containsAll(other.getDescriptions().values()) &&
				this.name.equals(other.getName()) &&
				this.nicknames.values().containsAll(other.getNicknames().values())
			){
				return true;
			}
		}
		return false;
	}
}
