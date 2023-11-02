/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ulti;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Thinkpad E440
 */
public class DialogHelper {

    public static void alert(Component parent, String messenger) {

        JOptionPane.showMessageDialog(parent, messenger, "He Thong Quan Ly dao tao", 1);

    }

    public static boolean confirm(Component parent, String messenger) {

        int choose = JOptionPane.showConfirmDialog(parent, messenger, "He Thong Quan Ly dao tao", 0, JOptionPane.YES_NO_OPTION);

        if (choose == JOptionPane.YES_OPTION) {
            return true;
        } else {
            return false;
        }

    }

    public static String prompt(Component parent,String title) {
        String text = JOptionPane.showInputDialog(parent, "", title, JOptionPane.INFORMATION_MESSAGE);
        return text;

    }

}
