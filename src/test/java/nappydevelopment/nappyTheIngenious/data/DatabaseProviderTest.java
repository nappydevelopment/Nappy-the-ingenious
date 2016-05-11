package nappydevelopment.nappyTheIngenious.data;

import org.junit.Test;

import java.sql.SQLException;
import java.sql.Statement;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNotNull;

public class DatabaseProviderTest{
	@Test
	public void closeConnection() throws SQLException{
		Statement st = DatabaseProvider.getStatement();
		DatabaseProvider.closeConnection();
		assertTrue(st.getConnection().isClosed());
		assertNotNull(DatabaseProvider.getStatement());
	}

}