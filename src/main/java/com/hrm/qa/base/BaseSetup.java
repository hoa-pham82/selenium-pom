package com.hrm.qa.base;

import static com.hrm.qa.util.TestUtil.USER_ROOT;

import com.hrm.qa.util.TestUtil;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseSetup {

  public static WebDriver driver;
  public static Properties prop;
  static String FILE_CONFIG_PATH = "/src/main/java/com/hrm/qa/config/config.properties";

  public BaseSetup() {
    try {
      prop = new Properties();

      FileInputStream ip = new FileInputStream(USER_ROOT + FILE_CONFIG_PATH);
      prop.load(ip);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void initialization() {
    String browser = prop.getProperty("browser");

    if (browser.equals("chrome")) {
      driver = new ChromeDriver();
    } else if (browser.equals("firefox")) {
      driver = new FirefoxDriver();
    }

    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT);
    driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITLY_WAIT);

    driver.get(prop.getProperty("url"));
  }

  public boolean verifyPageHeaderIsDisplayed(String page) {
    return driver.findElement(By.xpath(String.format("//h6[text()='%s']", page))).isDisplayed();
  }


}
