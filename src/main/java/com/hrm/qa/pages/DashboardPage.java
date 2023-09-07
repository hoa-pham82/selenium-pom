package com.hrm.qa.pages;

import com.hrm.qa.base.BaseSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BaseSetup {

  @FindBy(xpath = "//h6[text()='Dashboard']")
  WebElement dashBoardHeader;

  @FindBy(xpath = "//a")
  WebElement title;

  public DashboardPage() {
    PageFactory.initElements(driver, this);
  }

  public boolean verifyDashBoardHeader() {
    return this.dashBoardHeader.isDisplayed();
  }

  public BaseSetup navigateToPage(String title) {
    this.title.findElement(By.xpath(String.format("//*[text()='%s']", title)));
    switch (title) {
      case "Admin":
        return new AdminPage();
      case "Recruitment":
        return new RecruitmentPage();
      default:
        return null;
    }
  }

}
