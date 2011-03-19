package de.hypoport.jm.selenium2.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FailurePage {

  @FindBy(how = How.ID, using="error")
  private WebElement error;

  @FindBy(how = How.ID,  using="showlogin")
  private WebElement showloginLink;

  public boolean showsError() {
    return error.getText().equals("Error");
  }

}
