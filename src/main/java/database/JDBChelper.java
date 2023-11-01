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

    private static String url = "jdbc:sqlserver://localhost:1433;databaseName=nekodelivery";
    private static String user = "sa";
    private static String passSQL = "123";

    public static PreparedStatement getPreparedStatement(String sql, Object... objects) throws SQLException {

        Connection con = DriverManager.getConnection(url, user, passSQL);
        PreparedStatement pst;
        if (sql.startsWith("{")) {
            pst = con.prepareCall(sql);

        } else {
            pst = con.prepareStatement(sql);
        }
        int i = 1;
        for (Object object : objects) {
            pst.setObject(i, object);
            i++;

        }

        return pst;
    }

    public static ResultSet Query(String sql, Object... objects) {
        ResultSet rs = null;
        try {
            PreparedStatement ptm = getPreparedStatement(url, objects);
            rs = ptm.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(JDBChelper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    public static int Update(String sql, Object... objects) {

        try {
            PreparedStatement ptm = getPreparedStatement(url, objects);
            return ptm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(JDBChelper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

}
