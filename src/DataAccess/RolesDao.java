package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RolesDao {

	private Connection con = DbConnection.getInstance();

	public ResultSet getRoles() {
		PreparedStatement pstmt;
		ResultSet result = null;
		
		try {
			pstmt = con.prepareStatement("select * from roles");

			result = pstmt.executeQuery();

			return result;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
}
