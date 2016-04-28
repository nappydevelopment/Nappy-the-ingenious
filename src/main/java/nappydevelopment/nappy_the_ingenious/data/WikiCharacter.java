package nappydevelopment.nappy_the_ingenious.data;

import javafx.scene.image.Image;
import nappydevelopment.nappy_the_ingenious.data.settings.Language;

import java.util.Map;

public class WikiCharacter {
	private final String name;
	private final Map<Language, String> nicknames;
	private final Map<Language, String> descriptions;
	private final Image wikiImage;

	public WikiCharacter(
		String name,
		Map<Language, String> nicknames,
		Map<Language, String> descriptions,
		Image wikiImage
	) {
		this.name = name;
		this.nicknames = nicknames;
		this.wikiImage = wikiImage;
		this.descriptions = descriptions;
	}

	public String getName() {return name; }

	public String getNickname(final Language l) { return nicknames.get(l); }

	public String getDescription(final Language l) { return descriptions.get(l); }

	public Image getWikiImage() { return wikiImage; }

	@Override
	public String toString() { return this.name; }
}
