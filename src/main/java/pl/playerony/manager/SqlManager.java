package pl.playerony.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import pl.playerony.exception.DatabaseException;
import pl.playerony.util.Connector;
import pl.playerony.util.JdbcUtil;

public class SqlManager {
	private PreparedStatement preparedStatement;
	private Connection connection;
	private String sql;
	private Integer counter;
	
	public SqlManager() {
		super();
	}
	
	public SqlManager createQuery(final String sql) throws DatabaseException {
		this.sql = sql;
		this.counter = 1;
		
		initializeStatement();
		
		return this;
	}
	
	private void initializeStatement() throws DatabaseException {
		connection = Connector.connect();
		
		try {
			preparedStatement = connection.prepareStatement(sql);
		} catch (SQLException e) {
			throw new DatabaseException("Cannot create prepareStatement", e);
		}
	}
	
	public SqlManager setParameter(String value) throws DatabaseException {
		try {
			preparedStatement.setString(counter, value);
		} catch (SQLException e) {
			throw new DatabaseException("Cannot set this parameter", e);
		}
		
		counter++;
		
		return this;
	}
	
	public Integer executeQuery() throws DatabaseException {
		Integer value = 0;
		
		try {
			value = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new DatabaseException("Some problems by query executing", e);
		} finally {
			close();
		}
		
		return value;
	}
	
	public void close() throws DatabaseException {
		JdbcUtil.closeStatement(preparedStatement);
		Connector.closeConnection(connection);
	}
}
