package resources;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

    public static String getData(String testCaseName, String columnName) throws IOException {
        FileInputStream file = null;
        Workbook book = null;
        
        try {
            file = new FileInputStream(
                "C:\\Users\\ishiv\\Downloads\\Batch3FinalProject (1)\\Batch3FinalProject\\src\\main\\java\\resources\\TestData.xlsx"
            );
            book = new XSSFWorkbook(file);
            Sheet sheet = book.getSheet("LoginTest"); // Ensure correct sheet
            
            if (sheet == null) {
                throw new IOException("Sheet 'LoginTest' not found in Excel");
            }

            int rowCount = sheet.getPhysicalNumberOfRows();
            int colIndex = -1;

            // Find the correct column index
            Row firstRow = sheet.getRow(0);
            for (int j = 0; j < firstRow.getPhysicalNumberOfCells(); j++) {
                if (firstRow.getCell(j).getStringCellValue().equalsIgnoreCase(columnName)) {
                    colIndex = j;
                    break;
                }
            }

            if (colIndex == -1) {
                throw new IOException("Column '" + columnName + "' not found in Excel");
            }

            // Find the correct row
            for (int i = 1; i < rowCount; i++) {
                Row row = sheet.getRow(i);
                if (row != null && row.getCell(0) != null && 
                    row.getCell(0).getStringCellValue().equalsIgnoreCase(testCaseName)) {
                    
                    Cell cell = row.getCell(colIndex);
                    
                    if (cell != null) {
                        switch (cell.getCellType()) {
                            case STRING:
                                return cell.getStringCellValue();
                            case NUMERIC:
                                return String.valueOf((int) cell.getNumericCellValue());
                            case BOOLEAN:
                                return String.valueOf(cell.getBooleanCellValue());
                            case BLANK:
                                return "";
                            default:
                                return "";
                        }
                    }
                }
            }
        } finally {
            if (book != null) book.close();
            if (file != null) file.close();
        }
        return null;
    }
}