package StudentManager;

import examples.content.sfo.Main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hunglv
 */
public class JdbcUtil {
    private String username = null;
    private String password = null;
    private String url = null;
    private String driver = null;
    
    private Connection connection = null;
    private static JdbcUtil _jdbcUtils = null;
    Properties properties = null;
    
    static JdbcUtil getInstance() {
        if(_jdbcUtils == null) {
            _jdbcUtils = new JdbcUtil();
        }
        return _jdbcUtils;
    }
    
    public void init() {
        properties = new Resource().getResource("properties/connection.properties");
        
        url = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
        driver = properties.getProperty("JDBC_DRIVER");
    }
    
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    public Connection getConnection() {
        try {
            init();
            Class.forName(driver);
            connection = DriverManager.getConnection(url,username,password);
        }
        catch (SQLException e) {
            System.out.println("Cannot connect to database.");
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            System.out.println("Class not found.");
            e.printStackTrace();
        }
        
        return connection;
    }
    
    public ResultSet getResult(Statement stmt, String query) {
        ResultSet result = null;
        try {
            result = stmt.executeQuery(query);
        }
        catch(SQLException e) {
            System.out.println("Exception when getting data from database.");
            e.printStackTrace();
        }
        
        return result;
    }
    
    public void disConnection(Statement stmt) {
        try {
            if(stmt != null) {
                stmt.close();
                connection.close();
            }
        }
        catch (SQLException e) {
            System.out.println("Exception when disconnection with database.");
        }
    }
    
    /* public static void main(String[] args) {
        JdbcUtil test = JdbcUtil.getInstance();

        try {
            Connection conn = test.getConnection();
            Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id, first, last, age FROM Employees");
             
             while(rs.next()){
         //Retrieve by column name
         int id  = rs.getInt("id");
         int age = rs.getInt("age");
         String first = rs.getString("first");
         String last = rs.getString("last");

         //Display values
         System.out.print("ID: " + id);
         System.out.print(", Age: " + age);
         System.out.print(", First: " + first);
         System.out.println(", Last: " + last);
      }
        }
        catch (SQLException e) {
            System.out.println("SQL exception.");
            e.printStackTrace();
        }
    } */
}