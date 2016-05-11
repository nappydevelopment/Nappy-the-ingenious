package nappydevelopment.nappyTheIngenious.data;

import javafx.scene.image.Image;
import nappydevelopment.nappyTheIngenious.data.character.*;
import nappydevelopment.nappyTheIngenious.data.character.Character;
import nappydevelopment.nappyTheIngenious.data.settings.Language;
import nappydevelopment.nappyTheIngenious.util.eastereggs.EastereggSearcher;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.stream.Collectors;

public class CharacterProvider{

	public static List<Character> getCharacters() { return getCharacters(""); }
	public static List<Character> getCharacters(String whereclause){
		List<Character> out = new ArrayList<>();
		try(Statement st = DatabaseProvider.getStatement()){
			String select = "SELECT name, male, age";
			for(Language l: Language.values()){
				select += ", description_"+ l.getCode().toLowerCase();
				select += ", nickname_"+ l.getCode().toLowerCase();
			}
			st.execute(select + " FROM SIMPSONS " + whereclause);
			ResultSet res = st.getResultSet();

			while(res.next()){
				String name = res.getString("name");
				boolean male = res.getBoolean("male");
				String age = res.getString("age");
				Map<Language, String> descriptions = new HashMap<>();
				Map<Language, String> nicknames = new HashMap<>();

				for(Language l: Language.values()){
					descriptions.put(l, res.getString("description_"+ l.getCode().toLowerCase()));
					nicknames.put(l, res.getString("nickname_"+ l.getCode().toLowerCase()));
				}
				Image img = new CharacterImage(name).get();
				Character chr = new Character(name, nicknames, descriptions, img, Gender.fromBool(male), Age.fromString(age));
				out.add(chr);
			}
			st.close();
			return out;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	public static List<Character> search(List<Character> list, CharacterFilter search){
		EastereggSearcher.lookForEasteregg(search.getSearchStr().toLowerCase());
		List<Character> out;
		out = list.stream()
			.filter(c -> {
				if(search.getSearchStr().isEmpty()){return true;}
				return c.getName().toLowerCase().contains(search.getSearchStr());
			})
			.filter(c -> c.getGender().equals(search.getGender()))
			.filter(c -> c.getAge().equals(search.getAge()))
			.sorted(new CharacterNameComparator())
			.collect(Collectors.toList());
		return out;
	}
}
