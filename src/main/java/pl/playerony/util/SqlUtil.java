package pl.playerony.util;

import pl.playerony.exception.DatabaseException;
import pl.playerony.manager.SqlManager;

public class SqlUtil {
	private SqlManager sqlManager;

	public SqlUtil() {
		sqlManager = new SqlManager();
	}

	public Boolean checkId(String tableName, Long value) throws DatabaseException {
		String sql = "SELECT * " 
				   + "	FROM " + tableName 
				   + " WHERE id = ?";

		Boolean isExist = sqlManager.createQuery(sql)
									.setParameter(value)
									.isExist();

		return isExist;
	}
}
