package com.hrm.qa.pages;

import com.hrm.qa.base.BaseSetup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecruitmentPage extends BaseSetup {

  public RecruitmentPage() {
    PageFactory.initElements(driver, this);
  }
  
}
