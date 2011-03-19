package de.hypoport.jm.selenium2.infrastructure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SeleniumLogger extends AbstractWebDriverEventListener {

  final Logger log = LoggerFactory.getLogger(SeleniumLogger.class);

  @Override
  public void afterChangeValueOf(WebElement element, WebDriver driver) {
    log.info("Changed value of element '" + element.getAttribute("id") + "' to '" + element.getAttribute("value") + "'");
    super.afterChangeValueOf(element, driver);
  }

  @Override
  public void beforeClickOn(WebElement element, WebDriver driver) {
    log.info("Click on '" + element.getTagName() + "' with id '" + element.getAttribute("id") + "'");
    super.beforeClickOn(element, driver);
  }
}
