package de.hypoport.jm.selenium2.tests;

import de.hypoport.jm.selenium2.infrastructure.SeleniumBrowser;
import de.hypoport.jm.selenium2.pages.FailurePage;
import de.hypoport.jm.selenium2.pages.LoginPage;
import de.hypoport.jm.selenium2.pages.SuccessPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

public class LoginIntegrationTest {

  private LoginPage loginPage;
  private FailurePage failurePage;
  private SuccessPage successPage;
  private String validUsername= "Oliver";

  @BeforeMethod
  public void setUp() {
    loginPage = PageFactory.initElements(SeleniumBrowser.getBrowser(), LoginPage.class);
  }

  @Test
  public void Login_mit_falschem_Passwort() {
    Wenn_ich_mich_mit_falschem_Passwort_einlogge();
    Sehe_ich_eine_Fehlermeldung();
  }

  @Test
  public void Login_mit_gueltigen_Nutzernamen_und_Passwort() {
    Wenn_ich_mich_mit_gueltigem_Nutzernamen_einlogge();
    Sehe_ich_eine_Willkommens_Meldung_mit_meinem_Name();
  }

  private void Sehe_ich_eine_Willkommens_Meldung_mit_meinem_Name() {
    assertThat(successPage.getWelcomeMessage()).contains(validUsername);
  }

  private void Wenn_ich_mich_mit_gueltigem_Nutzernamen_einlogge() {
   successPage = loginPage.loginWithValidCredentials(validUsername, "secret");
  }

  private void Wenn_ich_mich_mit_falschem_Passwort_einlogge() {
    failurePage = loginPage.loginWithWrongCredentials();
  }

  private void Sehe_ich_eine_Fehlermeldung() {
    assertThat(failurePage.showsError()).isTrue();
  }

  @AfterTest
  public void tearDown() {
    SeleniumBrowser.getBrowser().close();
  }
}
