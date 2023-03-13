package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBContext {

    public Connection getConnection(){
        Connection conn = null;
        //URL: connection string: address, port, database of server
        try {
            //Call Driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //Connection

            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=SWD392_SE1609", "sa", "123456");

            System.out.println("Connected");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return conn;
    }
    
    public ResultSet getData(String sql) {
        Connection conn = getConnection();
        ResultSet rs = null;
        
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
            
            rs = state.executeQuery(sql);                     
        } catch (SQLException ex) {
            ex.printStackTrace();
        }     
        
        return rs;
    }

//    public DBContext() {
//        this("jdbc:sqlserver://localhost:1433;databaseName=ElectronicShop", "sa", "123456");
//    }
//    public ResultSet getData(String sql) throws Exception {
//        try {
//            Statement state  = getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
//                    ResultSet.CONCUR_UPDATABLE);
//            ResultSet rs = state.executeQuery(sql);
//            return rs;
//
//        } catch (SQLException ex) {
//            throw ex;
//        }
//
//    }
    
    public void closeConnection(Connection conn){
        if(conn!=null){    
            try {
                conn.close();
            } catch (SQLException ex) {
            }
        }
    }
    
    public void closePrepareStatement(PreparedStatement pre){
        if(pre != null){
            try {
                pre.close();
            } catch (SQLException ex) {
            }
        }
    }
    
    public void closeRS(ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException ex) {
            }
        }
    }

    public static void main(String[] args) {
        try {
            new DBContext().getConnection();
        } catch (Exception ex) {
        }
    }
}
