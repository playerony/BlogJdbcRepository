package pl.playerony.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import pl.playerony.exception.DatabaseException;

public class Connector {
	private static final String URL = "jdbc:mysql://localhost:3306/blog";
	private static final String LOGIN = "root";
	private static final String PASSWORD = "haslo";
	
	public static Connection connect() throws DatabaseException{
		Connection connection = null;
		
		try{
			connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
		}catch(Exception e){
			throw new DatabaseException("Problem by database connection", e);
		}
		
		return connection;
	}
	
	public static void closeConnection(Connection connection) throws DatabaseException{
		try{
			if(connection != null)
				connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
