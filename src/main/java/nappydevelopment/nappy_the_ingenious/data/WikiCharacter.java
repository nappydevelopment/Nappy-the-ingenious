package nappydevelopment.nappy_the_ingenious.data;

import javafx.scene.image.Image;
import nappydevelopment.nappy_the_ingenious.data.settings.Language;

import java.util.Map;

public class WikiCharacter {
	private final String name;
	private final Map<Language, String> nicknames;
	private final Map<Language, String> descriptions;
	private final Image wikiImage;
	private final boolean male;
	private final Age age;


	public WikiCharacter(
			String name,
			Map<Language, String> nicknames,
			Map<Language, String> descriptions,
			Image wikiImage,
			boolean male,
			Age age
	) {
		this.name = name;
		this.nicknames = nicknames;
		this.wikiImage = wikiImage;
		this.descriptions = descriptions;
		this.male = male;
		this.age = age;
	}


	public boolean isMale() {
		return male;
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
