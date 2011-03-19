package de.hypoport.jm.selenium2.infrastructure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class ReportingWebDriver extends EventFiringWebDriver {

  public ReportingWebDriver(final WebDriver webDriver) {
    super(webDriver);
    register(new SeleniumLogger());
  }
}