package nappydevelopment.nappy_the_ingenious.data;

import java.io.InputStream;
import java.sql.*;

public class DatabaseProvider{
	private static Connection dbConn;

	private static void createConnection(){
		try{
			Class.forName("org.h2.Driver").newInstance();
			dbConn = DriverManager.getConnection("jdbc:h2:./nappy;TRACE_LEVEL_FILE=0");
		}catch(SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e){
			e.printStackTrace();
			return;
		}

		try(Statement st = dbConn.createStatement()){
			st.execute(
				"SELECT count(0) as c FROM(\n" +
					"SELECT * FROM INFORMATION_SCHEMA.TABLES\n" +
					"WHERE TABLES.TABLE_NAME = 'SIMPSONS'\n" +
					"OR TABLES.TABLE_NAME = 'HIGHSCORES'\n" +
					"OR TABLES.TABLE_NAME like '%_QUESTIONS'\n" +
				");"
			);
			ResultSet res = st.getResultSet();
			if(res.next() && res.getInt("C") != 42){
				//not everything there
				resetDatabase();
			}
			res.close();
			st.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static boolean resetDatabase(){
		try(Statement st = getStatement()){
			InputStream initScriptStream = DatabaseProvider.class.getResourceAsStream("/db/simpsons.sql");
			java.util.Scanner s = new java.util.Scanner(initScriptStream).useDelimiter("\\A");
			String[] initScriptArray = s.next().split(";");
			for(String sa: initScriptArray){
				st.execute(sa);
			}
			st.close();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static Statement getStatement() throws SQLException{
		if(dbConn == null){
			createConnection();
		}
		return dbConn.createStatement();
	}

	public void closeDatabase(){
		try{
			dbConn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
