package nappydevelopment.nappyTheIngenious.data;

import javafx.scene.image.Image;
import nappydevelopment.nappyTheIngenious.data.character.*;
import nappydevelopment.nappyTheIngenious.data.character.Character;
import nappydevelopment.nappyTheIngenious.data.settings.Language;
import nappydevelopment.nappyTheIngenious.util.eastereggs.EastereggSearcher;
import nappydevelopment.nappyTheIngenious.util.eastereggs.ShowNelsonOnHaha;
import nappydevelopment.nappyTheIngenious.util.eastereggs.TonsOfHomer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.stream.Collectors;

public class CharacterProvider{
	static EastereggSearcher eggs = new EastereggSearcher();
	static TonsOfHomer toh = new TonsOfHomer();
	static ShowNelsonOnHaha haha = new ShowNelsonOnHaha();

	public static EastereggSearcher getEggs(){ return eggs; }
	public static TonsOfHomer getToh(){ return toh; }
	public static ShowNelsonOnHaha getHaha(){return haha;}

	public static List<Character> getCharacters(){ return getCharacters(""); }
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

	public static List<Character> search(List<Character> list, CharacterFilter search) {
		int i = eggs.lookFor(search.getSearchStr());
		List<Character> out;
		if( i == 1){
			return haha.getThem(list, search);
		}else if(i == 2) {
			return toh.getThem(list, search);
		}

		out = list.stream()
			.filter(c -> {
				if(search.getSearchStr().isEmpty()){return true;}
				return c.getName().toLowerCase().contains(search.getSearchStr());
			})
			.filter(c -> c.getGender().equals(search.getGender()))
			.filter(c -> c.getAge().equals(search.getAge()))
			.sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
			.collect(Collectors.toList());
		return out;
	}


}
