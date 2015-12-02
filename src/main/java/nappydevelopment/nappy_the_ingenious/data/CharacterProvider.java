package nappydevelopment.nappy_the_ingenious.data;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import nappydevelopment.nappy_the_ingenious.data.settings.Language;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class CharacterProvider{
	public static void main(String[] args){
		System.out.println(CharacterProvider.getCharacters(Language.GERMAN).get(2).getName());
	}

	public static List<WikiCharacter> getCharacters(Language lang){
		Statement st = DatabaseProvider.getStatement();
		List<WikiCharacter> out = new LinkedList<WikiCharacter>();
		try{
			if(st == null){return null;}
			st.execute("SELECT name, description_en, description_de, nickname FROM SIMPSONS");
			ResultSet res = st.getResultSet();

			while(res.next()){
				String name = res.getString("name");
				String nickname = res.getString("nickname");
				//InputStream image = res.getBinaryStream("image");
				String description_en = res.getString("description_en");
				String description_de = res.getString("description_de");
				System.out.println(description_de);
				Image img = null;
				/*try{
					BufferedImage bImg = ImageIO.read(image);
					img = SwingFXUtils.toFXImage(bImg, null);
				}catch(IOException e){
					e.printStackTrace();
				}*/

				WikiCharacter chr;
				if(lang.equals(Language.GERMAN)){ //TODO:fix condition
					// description==de
					chr = new WikiCharacter(name, nickname, description_de, img);
				}else{
					// description==en
					chr = new WikiCharacter(name, nickname, description_en, img);
				}
				out.add(chr);
			}
			st.close();
			return out;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
}
