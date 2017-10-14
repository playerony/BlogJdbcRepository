package pl.playerony.util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import pl.playerony.exception.DatabaseException;

public class JdbcUtil {
	public static ResultSet getResultSet(Statement statement, final String SQL) throws DatabaseException {
		ResultSet resultSet = null;
		try {
			resultSet = statement.executeQuery(SQL);
			
			if(resultSet == null)
				throw new DatabaseException("Error with creating resultSet, SQL: " + SQL);
			
			return resultSet;
		} catch(SQLException e) {
			throw new DatabaseException("Cant create resultSet", e);
		}
	}
	
	public static ResultSet getResultSet(PreparedStatement preparedStatement) throws DatabaseException {
		ResultSet resultSet = null;
		try {
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet == null)
				throw new DatabaseException("Error with creating resultSet, SQL: " + preparedStatement.toString());
			
			return resultSet;
		} catch(SQLException e) {
			throw new DatabaseException("Cant create resultSet", e);
		}
	}
	
	public static void closeResultSet(ResultSet resultSet) {
		try {
			if (resultSet != null)
				resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void closeStatement(Statement statement) {
		try {
			if (statement != null)
				statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
