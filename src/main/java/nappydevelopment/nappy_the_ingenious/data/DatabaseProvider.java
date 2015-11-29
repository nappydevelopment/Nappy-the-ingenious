package nappydevelopment.nappy_the_ingenious.data;

import java.io.InputStream;
import java.sql.*;

public class DatabaseProvider{
	private static Connection dbConn;

	//tests
	public static void main(String[] args) throws SQLException,ClassNotFoundException,InstantiationException,IllegalAccessException{
		DatabaseProvider.getConnection();
		Statement st = dbConn.createStatement();
		st.execute("SELECT * FROM SIMPSONS;");
		ResultSet res = st.getResultSet();
		res.next();
		System.out.println(res.getString("name"));
		return;
	}

	private static void createConnection(){
		try{
			Class.forName("org.h2.Driver").newInstance();

			dbConn = DriverManager.getConnection("jdbc:h2:./nappy;TRACE_LEVEL_SYSTEM_OUT=0");

			Statement st = dbConn.createStatement();

			//TODO: add all tables
			st.execute(
					"SELECT * FROM INFORMATION_SCHEMA.TABLES \n" +
					"WHERE TABLES.TABLE_NAME = 'SIMPSONS'\n" +
					"--AND TABLES.TABLE_NAME = 'SIMPSONS'"
			);
			if(!st.getResultSet().next()){
				// empty database
				initDatabase();
			}else{
				System.out.println("db exists");
			}
			st.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return;
	}

	private static void initDatabase(){
		try{
			InputStream initScriptStream = DatabaseProvider.class.getResourceAsStream("/main/db/simpsons.sql");
			java.util.Scanner s = new java.util.Scanner(initScriptStream).useDelimiter("\\A");
			String initScript = s.hasNext() ? s.next() : "";
			String[] initScriptArray = initScript.split(";"); // split into multiple statements because jdbc is stupid
			Statement st = dbConn.createStatement();
			for(String sa: initScriptArray){
				st.execute(sa);
			}
			st.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static Connection getConnection(){
		if(dbConn == null){
			createConnection();
		}
		return dbConn;
	}
}
