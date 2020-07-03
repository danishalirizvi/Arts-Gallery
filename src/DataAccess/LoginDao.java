package DataAccess;

import java.sql.*;

import Entities.Customers;
import model.UserModel;

public class LoginDao {

	private Connection con = DbConnection.getInstance();
	
	

	public Customers UserLogin(UserModel userModel) {
		PreparedStatement pstmt;
		try {

			pstmt = con.prepareStatement("SELECT * FROM Customers where login_name=? and Password=?");
			pstmt.setString(1, userModel.getUserName());
			pstmt.setString(2, new String(userModel.getPassword()));
	
			ResultSet rst = pstmt.executeQuery();

			while (rst.next()) {
        int user_id = rst.getInt(1);
        String f_name = rst.getString(2);
        String l_name = rst.getString(3);
        String username = rst.getString(4);
        String email = rst.getString(5);
        String password = rst.getString(6);
        String phone = rst.getString(7);
        String house_No = rst.getString(8);
        String stree2 = rst.getString(9);
        String street3 = rst.getString(10);
        String city = rst.getString(11);
        String country = rst.getString(12);
        int Admin_Check = rst.getInt(13);
        String website = rst.getString(14);
        return new Customers(user_id, f_name, l_name, username, email, password, phone, house_No,stree2,street3,city,country,Admin_Check,website);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


}
