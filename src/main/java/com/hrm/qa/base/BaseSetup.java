package com.hrm.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseSetup {

  private static WebDriver driver;
  static Properties prop;
  static String FILE_CONFIG_PATH = "/src/main/java/com/hrm/qa/config/config.properties";

  public BaseSetup() {
    try {
      prop = new Properties();
      String currentDir = System.getProperty("user.dir");

      FileInputStream ip = new FileInputStream(currentDir + FILE_CONFIG_PATH);
      prop.load(ip);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  public static WebDriver getDriver(String browser) {
    switch (browser) {
      case "chrome":
        driver = new ChromeDriver();
        break;
      case "firefox":
        driver = new FirefoxDriver();
        break;
      default:
        System.out.println("Browser: " + browser + " is not working, used Chrome as default!");
        driver = new ChromeDriver();
    }
    return driver;
  }

  public static void setup(String browser, String url) {
    WebDriver driver = BaseSetup.getDriver(browser);
    driver.get(url);
    driver.manage().window().maximize();
  }

  public static void teardown() {
    driver.quit();
  }
}
