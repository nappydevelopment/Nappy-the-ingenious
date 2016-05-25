package nappydevelopment.nappyTheIngenious.data.settings;

import nappydevelopment.nappyTheIngenious.data.DatabaseProvider;
import nappydevelopment.nappyTheIngenious.exception.CouldNotSaveToDatabase;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Settings implements Serializable{

	private Language language = Language.GERMAN;
	private ColorScheme coloScheme = ColorScheme.BRIGHT;
	private GameMode gameMode = GameMode.BOTH_MODES;

	private static volatile Settings singleton = new Settings();

	private Settings(){ this(true); }
	private Settings(final boolean loadFromDb){
		if(!loadFromDb){
			return;
		}
		try(Statement st = DatabaseProvider.getStatement()){
			// future optimization: st.execute("DROP Old lines");
			st.execute("SELECT * FROM SETTINGS ORDER BY ID DESC LIMIT 1;");
			ResultSet res = st.getResultSet();
			if(res.next()){
				Settings settings = (Settings) res.getObject("SETTINGS");
				this.gameMode = settings.gameMode;
				this.coloScheme = settings.coloScheme;
				this.language = settings.language;
			}
		}catch(SQLException e){
			System.out.println(
				"Could not load Settings from Database, everything seems fine\n" +
				"this could mean that the Database should be reset"
			);
		}
	}

	public static void saveToDatabase() throws CouldNotSaveToDatabase{
		try(PreparedStatement st = DatabaseProvider.prepareStatement("INSERT INTO SETTINGS(SETTINGS) values(?);")){
			st.setObject(1, singleton);
			st.execute();
		}catch(SQLException e){
			throw new CouldNotSaveToDatabase(e);
		}
	}
	public static Settings get(){ return singleton; }

	// internal api: do not use!
	protected static void reset(final boolean loadFromDb){ singleton = new Settings(loadFromDb); }

	public static ColorScheme getColoScheme(){ return get().coloScheme; }
	public static void setColoScheme(ColorScheme coloScheme){ get().coloScheme = coloScheme; }

	public static GameMode getGameMode(){ return get().gameMode; }
	public static void setGameMode(GameMode gameMode){ get().gameMode = gameMode;}

	public static Language getLanguage(){ return get().language; }
	public static void setLanguage(Language language){ get().language = language; }
}
