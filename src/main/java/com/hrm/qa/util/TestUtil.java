package com.hrm.qa.util;

import java.time.Duration;

public class TestUtil {

  public static Duration PAGE_LOAD_TIMEOUT = Duration.ofSeconds(20);
  public static Duration IMPLICITLY_WAIT = Duration.ofSeconds(10);

  public enum PageTitle {
    ADMIN("Admin"),
    PIM("PIM"),
    LEAVE("Leave"),
    TIME("Time"),
    RECRUITMENT("Recruitment"),
    MY_INFO("My Info"),
    PERFORMANCE("Performance"),
    DASHBOARD("Dashboard"),
    DIRECTORY("Directory"),
    MAINTENANCE("Maintenance"),
    CLAIM("Claim"),
    BUZZ("Buzz");
    final String value;

    PageTitle(String value) {
      this.value = value;
    }
  }


}
