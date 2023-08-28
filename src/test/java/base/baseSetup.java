package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class baseSetup {

  private static WebDriver driver;

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
    baseSetup.getDriver(browser);
    driver.get(url);
    driver.manage().window().maximize();
  }

  public static void teardown() {
    driver.quit();
  }
}
