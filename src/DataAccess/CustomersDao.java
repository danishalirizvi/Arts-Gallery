package DataAccess;

import Entities.Art;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entities.Customers;
import javax.swing.JOptionPane;
import model.UserModel;

public class CustomersDao {
	private Connection con = DbConnection.getInstance();

	public Customers getActiveUser(UserModel user) {
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("select * from Customers where Email_Address = ? and Password = ?");
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, new String(user.getPassword()));			
			ResultSet result = pstmt.executeQuery();		
			
			return new Customers(
					Integer.parseInt(result.getString(0)),
							result.getString(1),
							result.getString(2),
							result.getString(3),
							result.getString(4),
							result.getString(5),
							result.getString(6),
							result.getString(7),
                                			result.getString(8),
                                			result.getString(9),
                                			result.getString(10),
                                			result.getString(11),
                                			Integer.parseInt(result.getString(12)),
                                			result.getString(13)
							);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ResultSet getAdmins() {
		PreparedStatement pstmt;
		ResultSet result = null;
		try {			
			pstmt = con.prepareStatement("select * from Customers where Admin_Check=2");
			ResultSet rst = pstmt.executeQuery();			
			return rst;
		} catch (

		SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public ResultSet getUsers() {
		PreparedStatement pstmt;
		ResultSet result = null;
		String query = "";

		try {
			query = "select * from Customers where Admin_Check=1";			
			pstmt = con.prepareStatement(query);
			result = pstmt.executeQuery();
			return result;
		} catch (

		SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public ResultSet getArts() {
		PreparedStatement pstmt;
		ResultSet result = null;
		try {			
			pstmt = con.prepareStatement("SELECT * from Art join Customers on Art.Artist_Id = Customers.Customer_Id");
			ResultSet rst = pstmt.executeQuery();			
			return rst;
		} catch (

		SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	
	public ResultSet getArtists() {
		PreparedStatement pstmt;
		ResultSet result = null;
		try {			
			pstmt = con.prepareStatement("SELECT * FROM Customers where Admin_Check=0");
			ResultSet rst = pstmt.executeQuery();			
			return rst;
		} catch (

		SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public ResultSet InsertUsers(Customers user) {
		try {
			String query = "insert into Customers " + "(First_N,Last_N,Login_Name,Email_Address,Password,Phone_No,Apt_House_No,Street_Line2,Street_Line3,City,Country,Admin_Check,Website)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.f_name);
			pstmt.setString(2, user.l_name);
			pstmt.setString(3, user.username);
			pstmt.setString(4, user.email);
			pstmt.setString(5, new String(user.password));
                        pstmt.setString(6, "12312313");
			pstmt.setString(7, user.stree2);
			pstmt.setString(8, user.stree2);
			pstmt.setString(9, user.stree2);
                        pstmt.setString(10, user.stree2);
                        pstmt.setString(11, user.stree2);
                        
			pstmt.setInt(12, user.Admin_Check);
			pstmt.setString(13, user.stree2);
			pstmt.execute();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from Customers where Admin_check =" + user.Admin_Check);
			ResultSet rst = pstmt.executeQuery();
			return rst;			
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		return null;
	}
	
	public ResultSet UpdateUser(Customers user) {
		try {
			String query = "UPDATE Customers SET "
					+ "First_N='" + user.f_name
					+ "',Last_N='" + user.l_name
					+ "',Email_Address='" + user.email
					+ "',Login_Name='" + user.username
					+ "',Password='" +user.password
                                + "' where Login_Name='" + user.username + "'";
			
			System.out.print(query);
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.execute();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from Customers where Admin_Check = "+user.Admin_Check);
			ResultSet rst = pstmt.executeQuery();
			return rst;			
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		return null;
	}
	
	public ResultSet DeleteUsers(String username, int roleId) {
		try {
			String query = "delete from Customers where Email_Address ='" + username + "'";
                        System.out.println(query);
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.execute();
			
		} catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
		
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from Customers where Admin_Check =" + roleId);
			ResultSet rst = pstmt.executeQuery();
			return rst;			
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		return null;
	}

    public ResultSet DeleteArtist(String userName, int i) {
        try {
			String query = "delete from Contact_Form where Customer_Id = "
                                + "(select Customer_Id from Customers where Email_Address = '" + userName + "' limit 1)";
                        System.out.println(query);
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.execute();
                        System.out.println("deleted");
                         query = "delete from Customers where Email_Address = '" + userName + "'";
                        System.out.println(query);
			pstmt = con.prepareStatement(query);
			pstmt.execute();
                        System.out.println("deleted");
			
		} catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
		
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from Customers where Admin_Check =" + i);
			ResultSet rst = pstmt.executeQuery();
			return rst;			
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		return null; //To change body of generated methods, choose Tools | Templates.
    }

    public ResultSet insertArt(Art art) {
try {
			String query = "insert into Art " + "(Art_N,Artist_Id,Art_Type,Art_Description)"
					+ " values (?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, art.getTitle());
			pstmt.setString(2, JOptionPane.showInputDialog(null, "Artist Id"));
			pstmt.setString(3, art.getType());
                        pstmt.setString(4, "desc");
                        
			pstmt.execute();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from Art");
			ResultSet rst = pstmt.executeQuery();
			return rst;			
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		return null; 
    }

    public ResultSet deleteArt(Art art,String i) {
       try {
           String query = "delete from Likes where Art_Id = "
                                + "(select Art_Id from Art where Art_Id = " + i + " limit 1)";
                        System.out.println(query);
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.execute();
			 query = "delete from Art where Art_Id="+i;
                        System.out.println(query);
                         pstmt = con.prepareStatement(query);
			pstmt.execute();
                        System.out.println("deleted");
			
		} catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
		
		try {
			PreparedStatement pstmt = con.prepareStatement("SELECT * from Art join Customers on Art.Artist_Id = Customers.Customer_Id");
			ResultSet rst = pstmt.executeQuery();
			return rst;			
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		return null;//To change body of generated methods, choose Tools | Templates.
    }
}
