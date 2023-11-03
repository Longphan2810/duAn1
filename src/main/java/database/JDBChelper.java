/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thinkpad E440
 */
public class JDBChelper {
    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String url = "jdbc:sqlserver://localhost:1433;databaseName=nekodelivery";   
    private static String user = "sa";
    private static String passSQL = "123";

     static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
public static PreparedStatement getPreparedStatement(String sql, Object... args) throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, passSQL);
        PreparedStatement pstmt = null;
        if (sql.trim().startsWith("{")) {
            pstmt = connection.prepareCall(sql);
        } else {
            pstmt = connection.prepareStatement(sql);
        }
        for (int i = 0; i < args.length; i++) {
            pstmt.setObject(i + 1, args[i]);

        }
        return pstmt;
    }
    public static int Update(String sql, Object...args){
        try {
            PreparedStatement stmt= getPreparedStatement(sql, args);
            try {
                return stmt.executeUpdate();
            }finally{
                stmt.getConnection().close();
            }
            
        } catch (SQLException e) {
            throw new  RuntimeException(e);
        }
    }
    public static ResultSet Query(String sql, Object... args) {
        try {
            PreparedStatement stmt = getPreparedStatement(sql, args);
            return stmt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static Object value(String sql,Object... args) {
        try {
            ResultSet rs = Query(sql, args);
            if(rs.next()){
            return rs.getObject(0);
            
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
        
    }
}
