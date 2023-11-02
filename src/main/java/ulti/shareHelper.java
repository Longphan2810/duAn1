/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ulti;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

/**
 *
 * @author Thinkpad E440
 */
public class shareHelper {
    
    public static void saveLogo(File fileIn) throws FileNotFoundException, IOException {
        
        File parent = new File("src\\main\\resources\\logo");
        
        if(!parent.exists()){
            parent.mkdirs();
        }
        
        
        File fileOut = new File("src\\main\\resources\\logo", fileIn.getName());
        
        Path from = Paths.get(fileIn.getAbsolutePath());
        Path to = Paths.get(fileOut.getAbsolutePath());
        
        Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        
    }
    
    public static ImageIcon readLogo(String FileName) {
        File fileIn = new File("src\\main\\resources\\logo", FileName);
        
        return new ImageIcon(fileIn.getAbsolutePath());
    }
    
}
