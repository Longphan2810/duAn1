/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ulti;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

/**
 *
 * @author Thinkpad E440
 */
public class DateHelper {

    public static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public static String DateToString(Date date) {

        return sdf.format(date);

    }

    public static Date StringToDate(String date) throws ParseException {

        return sdf.parse(date);

    }

    public static Date GetDateNow() throws ParseException {

        Date d = new Date();
        return sdf.parse(sdf.format(d));

    }
    
  

    public static boolean validateDate(String date) {
        String[] arr = date.split("-");
        int day = Integer.parseInt(arr[0]);
        int mounth = Integer.parseInt(arr[1]);
        int year = Integer.parseInt(arr[2]);
        boolean checkNamNhuan = false;

        Hashtable<Integer, Integer> dataYear = new Hashtable<>();
        dataYear.put(1, 31);
        dataYear.put(3, 31);
        dataYear.put(4, 30);
        dataYear.put(5, 31);
        dataYear.put(6, 30);
        dataYear.put(7, 31);
        dataYear.put(8, 31);
        dataYear.put(9, 30);
        dataYear.put(10, 31);
        dataYear.put(11, 30);
        dataYear.put(12, 31);
        // kiem tra xem co phai nam nhuan k 
        if (year % 4 == 0 && year % 100 != 0) {
            checkNamNhuan = true;
            dataYear.put(2, 29);

        } else {
            checkNamNhuan = false;
            dataYear.put(2, 28);
        }
        // kiem tra ngay thang 
        if(mounth<1 || mounth>12){
            
        return false ;
        
        }
        
        if(day<1 || day>dataYear.get(mounth)){
        return false;
        }
        
        return true;
    }
}
