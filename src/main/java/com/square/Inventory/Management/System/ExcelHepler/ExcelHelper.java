package com.square.Inventory.Management.System.ExcelHepler;

import com.square.Inventory.Management.System.Entity.Budget;
import com.square.Inventory.Management.System.Entity.SBU;
import com.square.Inventory.Management.System.Entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Slf4j
public class ExcelHelper {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

    static String[] HEADERs = {"User Id", "FirstName", "LastName", "Email", "Contract Number", "Role", "Status", "WorkPlace"};
    static String SHEET = "User";

    public static boolean hasExcelFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            log.info("inside Excel check");

            return false;
        }

        return true;
    }

    public static List<Budget> excelToBudget(InputStream is) {
        try {
            Workbook workbook = WorkbookFactory.create(is);
            Sheet sheet = workbook.getSheetAt(0);


            Iterator<Row> rows = sheet.iterator();

            List<Budget> budgetList = new ArrayList<Budget>();

            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();

                Budget budget = new Budget();

                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();
                    String text = null;
                    switch (cellIdx) {
                        case 0:
                            budget.setBudgetID(Integer.parseInt(currentCell.getStringCellValue()));
                            break;

                        case 1:
                            budget.setSapCode(currentCell.getStringCellValue());
                            break;

                        case 2:
                            budget.setProductName(currentCell.getStringCellValue());
                            break;

                        case 3:
                            budget.setProductionUnit(Integer.parseInt(currentCell.getStringCellValue()));
                            break;
                        case 4:
                            budget.setPackageSize(Integer.parseInt(currentCell.getStringCellValue()));
                            break;
                        case 5:
                            budget.setSbu(SBU.valueOf(currentCell.getStringCellValue()));
                            break;
                        case 6:
                            budget.setFieldColleagueName(currentCell.getStringCellValue());
                            break;
                        case 7:
                            budget.setFieldColleagueID(currentCell.getStringCellValue());
                            break;
                        case 8:
                            budget.setQuantity((int) currentCell.getNumericCellValue());
                            break;
                        case 9:
                            budget.setDepotName(currentCell.getStringCellValue());
                            break;
                        case 10:
                            budget.setDepotID(currentCell.getStringCellValue());
                            break;
                        case 11:
                            budget.setCategory(currentCell.getStringCellValue());
                            break;
                        case 12:
                            budget.setMonth(currentCell.getStringCellValue());
                            break;
                        case 13:
                            budget.setYear((int) currentCell.getNumericCellValue());
                            break;
                        case 14:
                            budget.setSsu_id(currentCell.getStringCellValue());
                            break;
                        default:
                            break;
                    }

                    cellIdx++;
                }

                budgetList.add(budget);
            }

            workbook.close();

            return budgetList;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }


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

