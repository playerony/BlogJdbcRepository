package pl.playerony.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import pl.playerony.exception.DatabaseException;
import pl.playerony.util.Connector;

public class SqlManager {
	private PreparedStatement preparedStatement;
	private Connection connection;
	private String sql;
	private Integer counter;
	
	public SqlManager() {
		super();
	}
	
	public void createQuery(final String sql) throws DatabaseException {
		this.sql = sql;
		this.counter = 0;
		
		initializeStatement();
	}
	
	private void initializeStatement() throws DatabaseException {
		connection = Connector.connect();
		
		try {
			preparedStatement = connection.prepareStatement(sql);
		} catch (SQLException e) {
			throw new DatabaseException("Cannot create prepareStatement", e);
		}
	}
	
	public void setParameter(String value) throws DatabaseException {
		try {
			preparedStatement.setString(counter, value);
		} catch (SQLException e) {
			throw new DatabaseException("Cannot set this parameter", e);
		}
		
		counter++;
	}
	
	public Integer executeQuery() throws DatabaseException {
		Integer value = 0;
		
		try {
			value = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new DatabaseException("Some problems by query executing", e);
		}
		
		return value;
	}
}
