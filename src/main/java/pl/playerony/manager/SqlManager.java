package pl.playerony.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import pl.playerony.exception.DatabaseException;
import pl.playerony.model.Role;
import pl.playerony.util.Connector;
import pl.playerony.util.JdbcUtil;
import pl.playerony.util.converter.Converter;

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

	public SqlManager setParameter(Object value) throws DatabaseException {
		try {
			if (value instanceof Long) {
				System.out.println(value);
				preparedStatement.setLong(counter, (Long) value);
			} else
				preparedStatement.setString(counter, (String) value);
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

	public List<Object[]> getExecuteList() throws DatabaseException{
		ResultSet resultSet = JdbcUtil.getResultSet(preparedStatement);
		Integer columnsNumber = getColumnNumber(resultSet);
		
		List<Object[]> result = new LinkedList<>();
		Object[] row = new Object[columnsNumber];
		
		try {
			while (resultSet.next()) {
				for(int i = 1 ; i<=columnsNumber ; i++)
					row[i-1] = resultSet.getArray(i);

				result.add(row);
			}
		} catch (SQLException e) {
			throw new DatabaseException("Error database connection failed", e);
		} finally {
			close();
		}
		
		return result;
	}
	
	public Object[] getSingleValue() throws DatabaseException {
		ResultSet resultSet = JdbcUtil.getResultSet(preparedStatement);
		Integer columnsNumber = getColumnNumber(resultSet);
		
		Object[] row = new Object[columnsNumber];
		
		try {
			if (resultSet.next())
				for(int i = 1 ; i<=columnsNumber ; i++)
					row[i-1] = resultSet.getObject(i);
			
			if(resultSet.next())
				throw new DatabaseException("There exist more than one unique topic with ID");
		} catch (SQLException e) {
			throw new DatabaseException("Error database connection failed", e);
		} finally {
			close();
		}
		
		return row;
	}
	
	public Integer getColumnNumber(ResultSet resultSet) throws DatabaseException {
		ResultSetMetaData resultSetMetaData;
		Integer columnsNumber;
		
		try {
			resultSetMetaData = resultSet.getMetaData();
			columnsNumber = resultSetMetaData.getColumnCount();
		} catch (SQLException e) {
			throw new DatabaseException("Some problems by getColumnNumber ", e);
		}
		
		return columnsNumber;
	}

	public void close() throws DatabaseException {
		JdbcUtil.closeStatement(preparedStatement);
		Connector.closeConnection(connection);
	}
}
