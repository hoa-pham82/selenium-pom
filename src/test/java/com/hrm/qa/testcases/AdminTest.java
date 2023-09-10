package com.hrm.qa.testcases;

import com.hrm.qa.base.BaseSetup;
import com.hrm.qa.pages.AdminPage;
import com.hrm.qa.pages.AdminPage.AddUserLabel;
import com.hrm.qa.pages.DashboardPage;
import com.hrm.qa.pages.LoginPage;
import com.hrm.qa.util.TestUtil.PageTitle;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdminTest extends BaseSetup {

  DashboardPage dashboardPage;
  AdminPage adminPage;

  public AdminTest() {
    super();
  }

  @BeforeClass
  public void setup() {
    initialization();
    LoginPage loginPage = new LoginPage();
    dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    adminPage = dashboardPage.navigateToPage(PageTitle.ADMIN.value);
  }

  @Test()
  public void verifyAdminPageHeader() {
    Assert.assertTrue(verifyPageHeaderIsDisplayed(PageTitle.ADMIN.value),
        "The admin page header is not displayed!");
  }

  @Test(enabled = false)
  // TO-DO: fixed hidden option
  public void verifyAddUserSuccessfully() {
    adminPage.addNewUser();
    Assert.assertTrue(adminPage.verifyAddUserPageTitle(), "Add user page title is not displayed!");
    adminPage.selectOptionByLabel(AddUserLabel.USER_ROLE.label, "Admin");
    adminPage.typeToField(AddUserLabel.EMPLOYEE_NAME.label, "Ramesh");
    adminPage.selectOptionByLabel(AddUserLabel.STATUS.label, "Enabled");
    adminPage.typeToField(AddUserLabel.USERNAME.label, "Ramesh");
    adminPage.typeToField(AddUserLabel.PASSWORD.label, "Admin123");
    adminPage.typeToField(AddUserLabel.CONFIRM_PASSWORD.label, "Admin123");
    adminPage.saveNewUser();
  }

  @AfterClass
  public void teardown() {
    driver.quit();
  }
}
