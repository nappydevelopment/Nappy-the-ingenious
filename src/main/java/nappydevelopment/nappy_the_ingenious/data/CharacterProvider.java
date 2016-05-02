package nappydevelopment.nappy_the_ingenious.data;

import javafx.scene.image.Image;
import nappydevelopment.nappy_the_ingenious.GlobalReferences;
import nappydevelopment.nappy_the_ingenious.data.settings.Language;

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
				Image img = null;
				try{
					img = new Image(GlobalReferences.IMAGES_PATH + "wiki/" + name.toLowerCase().replace(" ", "_") + ".png");
				}catch(RuntimeException e){
					if(!"Internal graphics not initialized yet".equals(e.getMessage())){
						throw e;
					}
				}
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

	public static List<Character> search(List<Character> list, CharFilter search){
		List<Character> out;
		out = list.stream()
			.filter(c -> {
				if(search.getSearchStr().isEmpty()){return true;}
				return c.getName().toLowerCase().contains(search.getSearchStr().toLowerCase());
			})
			.filter(c -> c.getGender().equals(search.getGender()))
			.filter(c -> c.getAge().equals(search.getAge()))
			.sorted(new CharacterNameComparator())
			.collect(Collectors.toList());
		return out;
	}
}
