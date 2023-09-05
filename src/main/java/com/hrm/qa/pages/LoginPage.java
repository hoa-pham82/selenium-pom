package com.hrm.qa.pages;

import com.hrm.qa.base.BaseSetup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseSetup {

  // Page Factory - OR (object repository)
  @FindBy(name = "username")
  WebElement username;
  @FindBy(name = "password")
  WebElement password;
  @FindBy(css = "[type='submit']")
  WebElement submitButton;

  public LoginPage() {
    PageFactory.initElements(driver, this);
  }

  public String validateLoginTitle() {
    return driver.getTitle();
  }

  public void login(String username, String password) {
    this.username.sendKeys(username);
    this.password.sendKeys(password);
    this.submitButton.click();
  }


}
