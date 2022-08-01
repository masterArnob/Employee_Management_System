/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.x4_1;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Asus
 */
public class DatabaseConnection
{
     public Connection databaseLink;
    public Connection getDBConnection()
    {
        String databaseName="test34";
        String databaseUser="root";
        String databasePassword="MiniSh03@";
        String url="jdbc:mysql://localhost/"+databaseName;
        
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return databaseLink;
    }
    
}
