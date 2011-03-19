package de.hypoport.jm.selenium2.infrastructure;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class WebDriverFactory {

  private static WebDriverFactory instance = new WebDriverFactory();
  public static String BROWSER_FIREFOX = "FF";
  public static String BROWSER_CHROME = "CHROME";
  public static String BROWSER_HTMLUNIT = "HU";
  private ReportingWebDriver reportingWebDriver;

  public static WebDriverFactory getInstance() {
    return instance;
  }

  private WebDriverFactory() {
  }

  public ReportingWebDriver createBrowser(String browser) {
    if (BROWSER_FIREFOX.equalsIgnoreCase(browser)) {
      reportingWebDriver = new ReportingWebDriver(new FirefoxDriver());
    }
    if (BROWSER_HTMLUNIT.equalsIgnoreCase(browser)) {
      reportingWebDriver = new ReportingWebDriver(new HtmlUnitDriver());
    }
    if (BROWSER_HTMLUNIT.equalsIgnoreCase(browser)) {
      reportingWebDriver = new ReportingWebDriver(new HtmlUnitDriver());
    }
    if (BROWSER_CHROME.equalsIgnoreCase(browser)) {
      reportingWebDriver = new ReportingWebDriver(new ChromeDriver());
    }
    if (reportingWebDriver == null) {
      throw new UnsupportedOperationException("Unsupported WebDriver : " + browser);
    }
    return reportingWebDriver;
  }
}