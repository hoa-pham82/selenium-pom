package com.hrm.qa.pages;

import com.hrm.qa.base.BaseSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage extends BaseSetup {

  @FindBy(xpath = "//label[text()='Username']/parent::div/following-sibling::div/input")
  WebElement userSearchBox;

  @FindBy(xpath = "//*[@type='submit']")
  WebElement searchBtn;

  @FindBy(xpath = "//*[text()[contains(., 'Add')]]")
  WebElement addUserBtn;
  @FindBy(xpath = "//h6[text()='Add User']")
  WebElement addUserTitle;
  @FindBy(xpath = "//*[text()[contains(., 'Save')]]")
  WebElement saveUserBtn;

  public enum AddUserLabel {
    USER_ROLE("User Role"),
    EMPLOYEE_NAME("Employee Name"),
    STATUS("Status"),
    USERNAME("Username"),
    PASSWORD("Password"),
    CONFIRM_PASSWORD("Confirm Password");
    public final String label;

    AddUserLabel(String label) {
      this.label = label;
    }
  }

  public AdminPage() {
    PageFactory.initElements(driver, this);
  }

  public void searchUserByName(String name) {
    this.userSearchBox.sendKeys(name);
    this.searchBtn.click();
  }

  public boolean verifyAddUserPageTitle() {
    return this.addUserTitle.isDisplayed();
  }

  public void typeToField(String fieldLabel, String content) {
    driver.findElement(
            By.xpath(String.format("//*[text()[contains(.,'%s')]]/following::input[1]", fieldLabel)))
        .sendKeys(content);
    if (fieldLabel.equals("Employee Name")) {
      driver.findElement(
          By.xpath("//*[@role='option' and span/text()[contains(., '" + content + "')]]")).click();
    }
  }

  public void selectOptionByLabel(String label, String option) {
    driver.findElement(
        By.xpath(String.format(
            "//*[text()[contains(., '%s')]]/following::div[@class='oxd-select-text-input']",
            label))).click();
    driver.findElement(
        By.xpath(".//*[@role='option' and span/text()[contains(., '" + option + "')]]")).click();
  }

  public void clickToAddUser() {
    this.addUserBtn.click();
  }

  public void addNewUser(String userRole, String employeeName, String status,
      String userName, String password, String confirmPassword) {

    selectOptionByLabel(AddUserLabel.USER_ROLE.label, userRole);
    typeToField(AddUserLabel.EMPLOYEE_NAME.label, employeeName);
    selectOptionByLabel(AddUserLabel.STATUS.label, status);
    typeToField(AddUserLabel.USERNAME.label, userName);
    typeToField(AddUserLabel.PASSWORD.label, password);
    typeToField(AddUserLabel.CONFIRM_PASSWORD.label, confirmPassword);

    this.saveUserBtn.click();

  }
  
}
