package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AdminPage;
import pages.BasePage;
import pages.LoginPage;
import setup.DriverFactory;
import setup.Util;

public class loginSteps {

    WebDriver driver;
    BasePage basePage;
    AdminPage adminPage;
    LoginPage loginPage;

    @Before
    public void tearUp(){
        driver = DriverFactory.getDriver("chrome");
        basePage = new BasePage(driver);
        adminPage = new AdminPage(driver);
        loginPage = new LoginPage(driver);
    }

    @After
    public void tearDown(){
        Util.pauseExecutionForSeconds(3);
        basePage.closeBrowser();
    }


    @Given("Launching Website for testing")
    public void launchApplication(){
        Util.pauseExecutionForSeconds(3);
        basePage.launchApplication("https://opensource-demo.orangehrmlive.com/");
    }

    @Given("I am on login page of application")
    public void verifyIfUserIsOnLoginPage(){
        loginPage.checkIfLoginPageVisible();
    }

    @Given("I enter valid user name and password")
    public void provideUserNameAndPassword(){
        loginPage.enterUserName(Util.getProperties("username"));
        loginPage.enterPassword(Util.getProperties("password"));
    }

    @Given("I enter invalid user name and password")
    public void provideInvalidUserNameAndPassword(){
        loginPage.enterUserName("tester");
        loginPage.enterPassword("Tester");
    }

    @Given("I click on login button")
    public void clickOnLoginButton(){
        loginPage.clickOnLoginButton();
    }

    @Given("I am landing on home page successfully")
    public void verifyLoginSuccessful(){
        Assert.assertTrue(basePage.checkIfUserIconDisplayed());
    }

    @Given("I am getting error for invalid credential")
    public void verifyLoginFailed(){
        Assert.assertTrue(loginPage.checkIfInvalidCredentialErrorDisplay());
    }


    @When("I enter username {string}")
    public void enterUserNameInTextBox(String userName){
        loginPage.enterUserName(userName);
        Util.pauseExecutionForSeconds(2);
    }

    @When("I enter password {string}")
    public void enterPasswordInTextBox(String password){
        loginPage.enterPassword(password);

    }





}
