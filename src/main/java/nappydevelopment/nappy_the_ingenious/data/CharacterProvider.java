package nappydevelopment.nappy_the_ingenious.data;

import javafx.scene.image.Image;
import nappydevelopment.nappy_the_ingenious.GlobalReferences;
import nappydevelopment.nappy_the_ingenious.data.settings.Language;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CharacterProvider{

	public static List<WikiCharacter> getCharacters(Language lang){
		Statement st = DatabaseProvider.getStatement();
		List<WikiCharacter> out = new ArrayList<WikiCharacter>();
		try{
			if(st == null){return null;}
			st.execute("SELECT name, description_en, description_de, nickname FROM SIMPSONS");
			ResultSet res = st.getResultSet();

			while(res.next()){
				String name = res.getString("name");
				String nickname = res.getString("nickname");
				String description_en = res.getString("description_en");
				String description_de = res.getString("description_de");

				Image img = new Image(GlobalReferences.IMAGES_PATH + "wiki/" + name.toLowerCase().replace(" ", "_") +".png");

				WikiCharacter chr = new WikiCharacter(name, nickname, description_de, description_en, img);
				out.add(chr);
			}
			st.close();
			out.sort(new WikiCharacterNameComparator());
			return out;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	public static List<WikiCharacter> search(List<WikiCharacter> list, String search){
		List<WikiCharacter> out;
		out = list.stream()
			.filter(wc -> {
				if(search.isEmpty()){return true;}
				return wc.getName().toLowerCase().contains(search.toLowerCase());
			})
			.sorted(new WikiCharacterNameComparator())
			.collect(Collectors.toList());
		return out;
	}
}
