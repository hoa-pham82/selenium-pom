package com.hrm.qa.testcases;

import com.hrm.qa.base.BaseSetup;
import com.hrm.qa.pages.DashboardPage;
import com.hrm.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends BaseSetup {

  LoginPage loginPage;
  DashboardPage dashboardPage;

  public LoginTest() {
    super();
  }

  @BeforeClass
  public void setup() {
    initialization();
    loginPage = new LoginPage();

  }

  @Test
  public void verifyLoginTitle() {
    String title = loginPage.validateLoginTitle();
    Assert.assertEquals(title, "OrangeHRM");
  }

  @Test
  public void verifyLoginSuccessfully() {
    dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    boolean isDashBoardHeaderDisplayed = dashboardPage.verifyDashBoardHeaderIsDisplayed();
    Assert.assertTrue(isDashBoardHeaderDisplayed);

  }

  @AfterClass
  public void teardown() {
    driver.quit();
  }


}
