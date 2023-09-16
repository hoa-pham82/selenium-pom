package com.hrm.qa.testcases;

import static com.hrm.qa.util.TestUtil.USER_ROOT;

import com.hrm.qa.base.BaseSetup;
import com.hrm.qa.pages.AdminPage;
import com.hrm.qa.pages.DashboardPage;
import com.hrm.qa.pages.LoginPage;
import com.hrm.qa.util.TestUtil;
import com.hrm.qa.util.TestUtil.PageTitle;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AdminTest extends BaseSetup {

  DashboardPage dashboardPage;
  AdminPage adminPage;
  String filePath = USER_ROOT + "/src/main/java/com/hrm/qa/testdata/HRM.xlsx";
  String sheetName = "user";

  public AdminTest() {
    super();
  }

  @BeforeMethod
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

  @Test(priority = 1, dataProvider = "getHRMTestData")
  public void verifyAddUserSuccessfully(String userRole, String employeeName, String status,
      String userName, String password, String confirmPassword) {
    adminPage.clickToAddUser();
    Assert.assertTrue(adminPage.verifyAddUserPageTitle(), "Add user page title is not displayed!");
    adminPage.addNewUser(userRole, employeeName, status, userName, password, confirmPassword);
  }

  @DataProvider
  public Object[][] getHRMTestData() {
    return TestUtil.getDataFromFile(filePath, sheetName);
  }

  @AfterMethod
  public void teardown() {
    driver.quit();
  }
}
