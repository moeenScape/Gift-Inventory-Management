package com.square.Inventory.Management.System.ExcelHepler;

import com.square.Inventory.Management.System.Entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import java.util.List;

@Slf4j
public class ExcelHelper {
    static String[] HEADERs = {"User Id", "FirstName", "LastName", "Email", "Contract Number", "Role", "Status", "WorkPlace"};
    static String SHEET = "User";


    //    *****<<<<For DownLoad >>>>****
    public static ByteArrayInputStream UserToExcel(List<User> userList) {

        try (Workbook workbook = new XSSFWorkbook();
             ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            Sheet sheet = workbook.createSheet(SHEET);

            Row headerRow = sheet.createRow(0);

            for (int col = 0; col < HEADERs.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(HEADERs[col]);
            }

            int rowIdx = 1;
            for (User user : userList) {
                Row row = sheet.createRow(rowIdx++);

                row.createCell(0).setCellValue(user.getUserID());
                row.createCell(1).setCellValue(user.getFirstName());
                row.createCell(2).setCellValue(user.getLastName());
                row.createCell(3).setCellValue(user.getEmail());
                row.createCell(4).setCellValue(user.getContactNumber());
                row.createCell(5).setCellValue(user.getRole());
                row.createCell(6).setCellValue(user.getStatus());
                row.createCell(8).setCellValue(user.getWorkPlace());
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
        }
    }

}

