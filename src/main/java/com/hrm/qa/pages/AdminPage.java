package com.hrm.qa.pages;

import com.hrm.qa.base.BaseSetup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage extends BaseSetup {

  @FindBy(xpath = "//h6[text()='Admin']")
  WebElement adminPageHeader;

  @FindBy(xpath = "//label[text()='Username']/parent::div/following-sibling::div/input")
  WebElement userSearchBox;

  @FindBy(xpath = "//*[@type='submit']")
  WebElement searchBtn;

  public AdminPage() {
    PageFactory.initElements(driver, this);
  }

  public boolean verifyAdminHeaderIsDisplayed() {
    return this.adminPageHeader.isDisplayed();
  }

  public void searchUserByName(String name) {
    this.userSearchBox.sendKeys(name);
    this.searchBtn.click();
  }
}
