package nappydevelopment.nappy_the_ingenious.data;

import java.io.InputStream;
import java.sql.*;

public class DatabaseProvider{
	private static Connection dbConn;

	private static void createConnection(){
		try{
			Class.forName("org.h2.Driver").newInstance();
			dbConn = DriverManager.getConnection("jdbc:h2:./nappy;TRACE_LEVEL_FILE=0");

			Statement st = dbConn.createStatement();
			st.execute(
				"SELECT count(0) as c FROM(\n" +
					"SELECT * FROM INFORMATION_SCHEMA.TABLES\n" +
					"WHERE TABLES.TABLE_NAME = 'SIMPSONS'\n" +
					"OR TABLES.TABLE_NAME = 'HIGHSCORES'\n" +
					"OR TABLES.TABLE_NAME like '%_QUESTIONS'\n" +
				");"
			);
			ResultSet res = st.getResultSet();
			res.next();
			if(res.getInt("C") != 42){
				//not everything there
				resetDatabase();
			}else{
				// System.out.println("db exists");
			}
			res.close();
			st.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return;
	}

	public static boolean resetDatabase(){
		try{
			InputStream initScriptStream = DatabaseProvider.class.getResourceAsStream("/db/simpsons.sql");
			java.util.Scanner s = new java.util.Scanner(initScriptStream).useDelimiter("\\A");
			String[] initScriptArray = s.next().split(";");
			Statement st = dbConn.createStatement();
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

	public static Connection getConnection(){
		if(dbConn == null){
			createConnection();
		}
		return dbConn;
	}

	public static Statement getStatement(){
		Statement st;
		if(dbConn == null){
			createConnection();
		}
		try{
			st = dbConn.createStatement();
		}catch(Exception e){
			return null;
		}
		return st;
	}

	public void closeDatabase(){
		try{
			dbConn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
