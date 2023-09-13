package com.hrm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestUtil {

  public static Duration PAGE_LOAD_TIMEOUT = Duration.ofSeconds(20);
  public static Duration IMPLICITLY_WAIT = Duration.ofSeconds(10);
  public static String USER_ROOT = System.getProperty("user.dir");

  public static Object[][] getDataFromFile(String filePath, String sheetName) {
    Object[][] data;

    try {
      FileInputStream file = new FileInputStream(filePath);
      XSSFWorkbook workbook = new XSSFWorkbook(file);
      XSSFSheet sheet = workbook.getSheet(sheetName);
      
      data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

      Iterator<Row> rowIterator = sheet.iterator();
      int rowIndex = 0;
      while (rowIterator.hasNext()) {
        Row row = rowIterator.next();
        Iterator<Cell> cellIterator = row.cellIterator();
        int colIndex = 0;
        while (cellIterator.hasNext()) {
          Cell cell = cellIterator.next();
          data[rowIndex][colIndex] = cell.toString();
          colIndex += 1;
        }
        rowIndex += 1;
      }
      file.close();
      return data;

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public enum PageTitle {
    ADMIN("Admin"),
    PIM("PIM"),
    LEAVE("Leave"),
    TIME("Time"),
    RECRUITMENT("Recruitment"),
    MY_INFO("My Info"),
    PERFORMANCE("Performance"),
    DASHBOARD("Dashboard"),
    DIRECTORY("Directory"),
    MAINTENANCE("Maintenance"),
    CLAIM("Claim"),
    BUZZ("Buzz");
    public final String value;

    PageTitle(String value) {
      this.value = value;
    }
  }

  // Create the method to get data from Excel file


}
