package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	private static Connection connection;
	private DbConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://52.215.185.140:3306/nouman_2018403?user=nouman_2018403&password=Qwerty500");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getInstance() {
		if (connection == null)
			new DbConnection();

		return connection;
	}

}
