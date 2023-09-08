package com.hrm.qa.pages;

import com.hrm.qa.base.BaseSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BaseSetup {


  @FindBy(xpath = "//a")
  WebElement title;

  public DashboardPage() {
    PageFactory.initElements(driver, this);
  }


  public <Any> Any navigateToPage(String title) {
    this.title.findElement(By.xpath(String.format("//*[text()='%s']", title))).click();
    switch (title) {
      case "Admin":
        return (Any) new AdminPage();
      case "Recruitment":
        return (Any) new RecruitmentPage();
      default:
        return null;
    }
  }

}
