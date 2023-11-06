package org.example.steps;

import static org.junit.jupiter.api.Assertions.assertTrue;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class StepHomePage extends PageObject {

    @FindBy(xpath = "//*[@id='app']/div[1]/div[1]/header/div[1]/div[1]/span/h6")
    WebElementFacade dashboardText;

    @Step("Successful login")
    public String getHomPageTitle() {
        String dashboardTitle = dashboardText.getText();
       return dashboardTitle;


    }
}