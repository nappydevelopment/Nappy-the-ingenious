package nappydevelopment.nappyTheIngenious.data.character;

import java.util.Comparator;

public class CharacterNameComparator implements Comparator<Character>{
	@Override
	public int compare(Character o1, Character o2){
		return o1.getName().compareTo(o2.getName());
	}
}
