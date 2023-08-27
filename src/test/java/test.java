import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class test {
  @Test
  void example(){
    WebDriver driver = new ChromeDriver();
    driver.get("https://google.com");
    driver.quit();
  }

}
