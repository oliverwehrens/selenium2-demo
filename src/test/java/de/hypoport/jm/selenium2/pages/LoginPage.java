package de.hypoport.jm.selenium2.pages;

import de.hypoport.jm.selenium2.infrastructure.SeleniumConfig;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static de.hypoport.jm.selenium2.infrastructure.SeleniumBrowser.getBrowser;
import static org.openqa.selenium.support.PageFactory.initElements;

public class LoginPage {

  @FindBy(how = How.ID, using="username")
  private WebElement username;

  @FindBy(how = How.ID, using="password")
  private WebElement password;

  @FindBy(how = How.ID, using="logmein")
  private WebElement loginButton;

  public FailurePage loginWithWrongCredentials() {
    gotoLoginPage();
    username.sendKeys("wrong");
    password.sendKeys("password");
    loginButton.click();
    return initElements(getBrowser(), FailurePage.class);
  }

  private void gotoLoginPage() {
    getBrowser().get(SeleniumConfig.getWebserverUrl());
  }

  public SuccessPage loginWithValidCredentials(String username, String password) {
    gotoLoginPage();
    this.username.sendKeys(username);
    this.password.sendKeys(password);
    loginButton.click();
    return initElements(getBrowser(), SuccessPage.class);
  }
}
