package de.hypoport.jm.selenium2.infrastructure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SeleniumBrowser {

  private static ReportingWebDriver driver;
  private static final Logger log = LoggerFactory.getLogger(SeleniumBrowser.class);

  public static synchronized ReportingWebDriver getBrowser() {
    if (driver == null) {
      initializeDriver();
    }
    return driver;
  }

  private static void initializeDriver() {
    log.debug("Configure WebDriver with " + SeleniumConfig.getConfigAsString());
    if (SeleniumConfig.isLocal()) {
      WebDriverFactory webDriverFactory = WebDriverFactory.getInstance();
      driver = webDriverFactory.createBrowser(SeleniumConfig.getBrowserType());
    }
    else {
      throw new UnsupportedOperationException("Could not initialize Driver with Config " + SeleniumConfig.getConfigAsString());
    }
  }
}