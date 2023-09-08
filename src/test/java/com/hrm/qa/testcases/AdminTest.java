package com.hrm.qa.testcases;

import com.hrm.qa.base.BaseSetup;
import com.hrm.qa.pages.AdminPage;
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

  @Test(enabled = false)
  public void verifyAdminPageHeader() {
    Assert.assertTrue(verifyPageHeaderIsDisplayed(PageTitle.ADMIN.value),
        "The admin page header is not displayed!");
  }

  @AfterClass
  public void teardown() {
    driver.quit();
  }
}
