package org.example.definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import org.example.steps.StepHomePage;
import org.example.steps.StepLoginPage;
import static org.junit.jupiter.api.Assertions.*;

public class LoginPageDefinitions {

    @Steps
    StepLoginPage loginPage;

    @Steps
    StepHomePage homePage;

    @Given("User is on Home page")
    public void openApplication() {
        loginPage.open();

    }

    @When("User enters username as {string}")
    public void enterUsername(String userName) {
        loginPage.inputUserName(userName);
    }

    @When("User enters password as {string}")
    public void enterPassword(String passWord) {
        loginPage.inputPassword(passWord);

        loginPage.clickLogin();
    }

    @Then("User should be able to login successfully")
    public void clickOnLoginButton() {

        assertTrue(homePage.getHomPageTitle().contains("Dashboard"));
    }

    @Then("User should be able to see error message {string}")
    public void unsuccessfulLogin(String expectedErrorMessage) {

        String actualErrorMessage = loginPage.errorMessage();
        assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Then("User should be able to see error message {string} below username")
    public void missingUsername (String expectedErrorMessage) {

        String actualErrorMessage = loginPage.missingUsernameErrorMessage();
        assertEquals(expectedErrorMessage, actualErrorMessage);
    }

}