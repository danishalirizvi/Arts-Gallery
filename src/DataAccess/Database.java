package DataAccess;


import java.sql.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ismi2
 */
public class Database {
    private static Connection con=null;
    public static Connection getConnection(){
        if(con!=null){
            System.out.println("Connection already exists");
            return con;
        }
        else
        try{
          Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://52.215.185.140:3306/nouman_2018403?user=nouman_2018403&password=Qwerty500");
            System.out.println("Connection complete");
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        }
        return con;
    }
   		
}
