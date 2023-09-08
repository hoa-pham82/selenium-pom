package com.hrm.qa.testcases;

import com.hrm.qa.base.BaseSetup;
import com.hrm.qa.pages.AdminPage;
import com.hrm.qa.pages.DashboardPage;
import com.hrm.qa.pages.LoginPage;
import com.hrm.qa.pages.RecruitmentPage;
import com.hrm.qa.util.TestUtil.PageTitle;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DashboardTest extends BaseSetup {


  DashboardPage dashboardPage;
  AdminPage adminPage;
  RecruitmentPage recruitmentPage;


  public DashboardTest() {
    super();
  }

  @BeforeClass
  public void setup() {
    initialization();
    LoginPage loginPage = new LoginPage();
    dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
  }

  @Test
  public void verifyToNavigateToAdminPage() {
    adminPage = dashboardPage.navigateToPage(PageTitle.ADMIN.value);
  }

  @Test
  public void verifyToNavigateToRecruitmentPage() {
    recruitmentPage = dashboardPage.navigateToPage(PageTitle.RECRUITMENT.value);
  }


  @AfterClass
  public void teardown() {
    driver.quit();
  }
}
