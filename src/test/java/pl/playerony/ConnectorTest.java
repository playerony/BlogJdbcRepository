package pl.playerony;

import java.sql.Connection;

import org.junit.Test;

import pl.playerony.exception.DatabaseException;
import pl.playerony.util.Connector;

public class ConnectorTest {
	
	@Test
	public void testConnector() {
		try {
			Connection connection = Connector.connect();
			Connector.closeConnection(connection);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
