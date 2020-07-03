package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArtDao {

	private Connection con = DbConnection.getInstance();

	public ResultSet getArtPieces() {
		PreparedStatement pstmt;
		ResultSet result = null;

		try {
			pstmt = con.prepareStatement("select * from Art");

			result = pstmt.executeQuery();

			return result;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public ResultSet getSearchResults(int a, String searchtext) {
		PreparedStatement pstmt;
		ResultSet result = null;
		String query = "";

		try {
			if (a == 1) {
				query = "SELECT * FROM Art where Art_N like '%"+searchtext+"%' ";
			} else if (a == 2) {
				query = "SELECT * FROM Art where Artist_Id=(select Customer_Id from Customers where Login_Name like '%"+searchtext+"% limit 1')";
			} else if (a == 3) {
				query = "SELECT * FROM Art where Art_Type like '%"+searchtext+"%'";
			}
			pstmt = con.prepareStatement(query);

			result = pstmt.executeQuery();

			return result;

		} catch (

		SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
}
