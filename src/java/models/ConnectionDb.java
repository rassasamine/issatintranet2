/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.sql.*;

/**
 *
 * @author ISSATSO
 */
public class ConnectionDb 
{
    public static Connection getConnexion () 
    {
        Connection con = null;
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tp1g2","root","");
            
        }
        catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
        return con;
    }
}
