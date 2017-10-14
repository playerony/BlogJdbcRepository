package pl.playerony;

import java.sql.Connection;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import pl.playerony.exception.DatabaseException;
import pl.playerony.util.Connector;

@SpringBootTest
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
