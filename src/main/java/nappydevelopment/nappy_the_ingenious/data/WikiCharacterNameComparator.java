package nappydevelopment.nappy_the_ingenious.data;

import java.util.Comparator;

public class WikiCharacterNameComparator implements Comparator<WikiCharacter>{
	@Override
	public int compare(WikiCharacter o1, WikiCharacter o2){
		return o1.getName().compareTo(o2.getName());
	}
}
