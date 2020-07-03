package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArtistsDao {
	
	private Connection con = DbConnection.getInstance();
	
	public ResultSet getArtists() {
		PreparedStatement pstmt;
		ResultSet result = null;
		
		try {
			pstmt = con.prepareStatement("select * from Customers where Admin_Check=0");

			result = pstmt.executeQuery();

			return result;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
}
