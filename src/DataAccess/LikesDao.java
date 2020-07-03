package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LikesDao {
	
	private Connection con = DbConnection.getInstance();

	public ResultSet getLikes() {
		PreparedStatement pstmt;
		ResultSet result = null;
		
		try {
			pstmt = con.prepareStatement("select * from likes");

			result = pstmt.executeQuery();

			return result;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
}
