    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ulti;

import entity.NhanVien;

/**
 *
 * @author Thinkpad E440
 */
public class Auth {

    public static NhanVien currentNhanVien = null;

    public static void getLogin(NhanVien nv) {
        currentNhanVien = nv;
    }

    public static void getLogout() {
        currentNhanVien = null;

    }

    public static boolean isLogin() {

        return currentNhanVien != null;

    }

    public static boolean isManager() {
        return currentNhanVien.isRole();
    }

}
