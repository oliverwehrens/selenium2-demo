package de.hypoport.jm.selenium2.infrastructure;

public class SeleniumConfig {

  public static boolean isLocal() {
    return true; // Boolean.parseBoolean(System.getProperty("selenium.local"));
  }

  public static String getBrowserType() {
    String browser = System.getProperty("selenium.browser.type");
    if (browser == null) {
      browser = WebDriverFactory.BROWSER_FIREFOX;
    }
    return browser;
  }

  public static String getRemoteUrl() {
    return System.getProperty("selenium.remote.url");
  }

  public static String getWebserverUrl() {
    String url = System.getProperty("webserver.url");
    if (url == null) {
      url = "http://localhost:8080/selenium2/showlogin.html";
    }
    return url;
  }

  public static String getConfigAsString() {
    return "Selenium Config\n" +
           "Browser Type       :" + getBrowserType() +
           "\nWebServer          :" + getWebserverUrl() +
           "\nTest running Local :" + isLocal();
  }
}