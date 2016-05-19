package nappydevelopment.nappyTheIngenious.data;

import nappydevelopment.nappyTheIngenious.data.character.Age;
import nappydevelopment.nappyTheIngenious.data.character.Character;
import nappydevelopment.nappyTheIngenious.data.character.CharacterFilter;
import nappydevelopment.nappyTheIngenious.data.character.Gender;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CharacterProviderTest{
	@Test
	public void getCharacters(){
		List<Character> list = CharacterProvider.getCharacters();
		assertNotNull(list);
		assertTrue("More than one Character", list.size() >= 1);
		assertTrue(list.get(0) instanceof Character);
	}
	@Test//(expected=SQLException.class)
	public void getCharactersSQLError() throws Exception{
		assertNull(CharacterProvider.getCharacters("nop1e?\\h"));
	}

	@Test
	public void search() throws Exception{
		CharacterFilter filter1 = new CharacterFilter("simp", Gender.UNKNOWN, Age.UNKNOWN);
		CharacterFilter filter2 = new CharacterFilter("simp", Gender.MALE, Age.UNKNOWN);
		CharacterFilter filter3 = new CharacterFilter("", Gender.UNKNOWN, Age.OLD);

		Character c1 = new Character("lisa simpson", null, null, null, Gender.FEMALE, Age.YOUNG);
		Character c2 = new Character("homer simpson", null, null, null, Gender.MALE, Age.ADULT);
		Character c3 = new Character("Burns", null, null, null, Gender.MALE, Age.OLD);

		List<Character> list = new ArrayList<>();
		list.add(c1);
		list.add(c2);
		list.add(c3);

		List<Character> list2 = new ArrayList<>();
		list2.add(c2);
		list2.add(c1);

		assertEquals(CharacterProvider.search(list, filter1), list2);
		assertEquals(CharacterProvider.search(list, filter2).get(0), c2);
		assertEquals(CharacterProvider.search(list, filter3).get(0), c3);
	}

}