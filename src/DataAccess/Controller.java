package DataAccess;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ismi2
 */
public class Controller {
    public static ResultSet Select(String q){
                PreparedStatement stmt = null;
                        ResultSet rs = null;
        try{
        Connection con = Database.getConnection();
            stmt = con.prepareStatement(q);
            rs = stmt.executeQuery();
                }
              catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
     public static void Execute(String q){
          Statement stmt = null;
          ResultSet rs = null;
        try{
        Connection con = Database.getConnection();
            stmt = (Statement)con.createStatement();
            stmt.executeUpdate(q);
                }
              catch (SQLException ex) {
                  System.out.println(ex.getMessage());
        }
                        
     }      
}
