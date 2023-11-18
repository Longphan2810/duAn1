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
import javax.swing.JTable;
import javax.swing.table.TableModel;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Thinkpad E440
 */
public class shareHelper {

    public static void saveLogo(File fileIn) throws FileNotFoundException, IOException {

        File parent = new File("src\\main\\resources\\logo");

        if (!parent.exists()) {
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

   public static void exportToExcel(JTable table, String filePath) {
    // Tạo thư mục cha nếu nó chưa tồn tại
    File file = new File(filePath);
    File parentDir = file.getParentFile();
    if (!parentDir.exists()) {
        try {
            parentDir.mkdirs();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    // Tạo một Workbook
    Workbook workbook = new SXSSFWorkbook();
    Sheet sheet = workbook.createSheet("Doanh thu");

    // Lấy model của table
    TableModel model = table.getModel();

    // Tạo hàng tiêu đề
    Row rows = sheet.createRow(0);
    for (int i = 0; i < model.getColumnCount(); i++) {
        Cell cell = rows.createCell(i);
        cell.setCellValue(model.getColumnName(i));
    }

    // Tạo các hàng dữ liệu
    for (int i = 0; i < model.getRowCount(); i++) {
        Row row = sheet.createRow(i + 1);
        for (int j = 0; j < model.getColumnCount(); j++) {
            Object cellValue = model.getValueAt(i, j);
            Cell cell = row.createCell(j);
            if (cellValue != null) {
                cell.setCellValue(cellValue.toString());
            } else {
                cell.setCellValue("");
            }
        }
    }

    // Xuất dữ liệu ra file Excel
    try (FileOutputStream out = new FileOutputStream(file)) {
        workbook.write(out);
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}


}
