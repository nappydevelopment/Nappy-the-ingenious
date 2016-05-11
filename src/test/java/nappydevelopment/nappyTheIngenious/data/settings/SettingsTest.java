package nappydevelopment.nappyTheIngenious.data.settings;

import nappydevelopment.nappyTheIngenious.data.DatabaseProvider;
import nappydevelopment.nappyTheIngenious.exception.CouldNotSaveToDatabase;
import org.junit.AfterClass;
import org.junit.Test;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertNotNull;

public class SettingsTest{
	@AfterClass
	public static void cleanUpTheMess(){
		DatabaseProvider.resetDatabase();
		Settings.reset(false);
	}

	@Test
	public void save() throws CouldNotSaveToDatabase{
		Settings.setLanguage(null);
		Settings.setColoScheme(null);
		Settings.setGameMode(null);

		Settings.saveToDatabase();
		Settings.reset(true);

		assertNull(Settings.getLanguage());
		assertNull(Settings.getColoScheme());
		assertNull(Settings.getGameMode());

		// restore state so the nulls don't get loaded!
		Settings.reset(false);
		Settings.saveToDatabase();

		assertNotNull(Settings.getLanguage());
		assertNotNull(Settings.getColoScheme());
		assertNotNull(Settings.getGameMode());
	}

	@Test
	public void resetWithEmptyDatabase() throws CouldNotSaveToDatabase{
		DatabaseProvider.resetDatabase();
		Settings.reset(true);
	}
}
