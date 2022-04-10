/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TudoApp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Gustavo
 */
public class ConnectionFactory {
    
    public static final String DRIVER= "com.mysql.jdbc.Drive";
   // public static final String URL= "jdbc:mysql://localhost:3306/todoApp";

 
     public static final String URL= "jdbc:mysql://localhost:3306/todoApp?characterEncoding=latin1&useConfigs=maxPerformance";
    public static final String USER= "root";
    public static final String PASS= "nn8ft85f";
    
    public static Connection getConnectin(){
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
           throw new RuntimeException("Erro de conexão com o banco de dados", ex);
        }
    } 
    
    public static void closeConnection(Connection connection){
        
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException ex) {
               throw new RuntimeException("Erro de conexão com o banco de dados", ex);
            }
        }
    }
    public static void closeConnection(Connection connection, Statement stmt){
        
            try {
                
        if(connection != null){
                connection.close();               
        }
        if(stmt != null){
            stmt.close();
        }
                
            } catch (SQLException ex) {
               throw new RuntimeException("Erro de conexão com o banco de dados", ex);
            }
        }
    public static void closeConnection(Connection connection, Statement stmt, ResultSet resultSet){
        
            try {
                
        if(connection != null){
                connection.close();               
        }
        if(stmt != null){
            stmt.close();
        }
        if(resultSet != null){
            resultSet.close();
        }
                
            } catch (SQLException ex) {
               throw new RuntimeException("Erro de conexão com o banco de dados", ex);
            }
        }
    
    
    
    
}
