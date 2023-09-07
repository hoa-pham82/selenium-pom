package com.hrm.qa.testcases;

import com.hrm.qa.base.BaseSetup;
import com.hrm.qa.pages.DashboardPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DashboardTest extends BaseSetup {

  DashboardPage dashboardPage;

  public DashboardTest() {
    super();
  }

  @BeforeClass
  public void setup() {
    initialization();
    dashboardPage = new DashboardPage();
  }

  @Test
  public void verifyToNavigateToAdminPage() {

  }


  @AfterClass
  public void teardown() {
    driver.quit();
  }
}
