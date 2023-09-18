package com.hrm.qa.util;

import com.github.javafaker.Faker;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtil {

  public static Duration PAGE_LOAD_TIMEOUT = Duration.ofSeconds(20);
  public static Duration IMPLICITLY_WAIT = Duration.ofSeconds(10);
  public static Duration EXPLICIT_WAIT = Duration.ofSeconds(10);
  public static String USER_ROOT = System.getProperty("user.dir");
  public static String random = getRandomName();

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
        int rowNum = row.getRowNum();
        if (rowNum != 0) {
          Iterator<Cell> cellIterator = row.cellIterator();
          int colIndex = 0;
          while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            if (colIndex == 3) {
              data[rowIndex][colIndex] = cell.toString() + random;
              colIndex += 1;
            } else {
              data[rowIndex][colIndex] = cell.toString();
              colIndex += 1;
            }

          }
          rowIndex += 1;
        }
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

  public static String getRandomName() {
    Faker faker = new Faker();
    return faker.name().lastName();
  }

  public static void waitForElementTobeVisible(WebDriver driver, By element, Duration timeout) {
    WebDriverWait wait = new WebDriverWait(driver, timeout);
    wait.until(ExpectedConditions.visibilityOfElementLocated(element));
  }
}
