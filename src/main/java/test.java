
import DAO.DonHangDAO;
import database.JDBChelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
/**
 *
 * @author Thinkpad E440
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here

        DonHangDAO dao = new DonHangDAO();
        List<Integer> ls = dao.selectBanChuaThanhToan();
        
//        for (Integer l : ls) {
//            System.out.println(l);
//        }
        System.out.println(ls.contains(5));
        
        
        
    }
}
