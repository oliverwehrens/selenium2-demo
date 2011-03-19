package de.hypoport.jm.selenium2.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SuccessPage {

  @FindBy(how = How.ID, using="welcome")
  private WebElement welcomeMessage;

  public String getWelcomeMessage() {
    return welcomeMessage.getText();
  }

}
