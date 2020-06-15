package com.ankitnandwani.cucumber.StepDefs;

import com.ankitnandwani.cucumber.Browser;
import com.ankitnandwani.cucumber.Hooks;
import com.ankitnandwani.cucumber.Repo.AppliFashion.FashionHome;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.fluent.Target;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public class GridPage {

    private Browser browser;
    private WebDriver driver;
    private Eyes eyes;
    private FashionHome fashionHome;
    Hooks hooks = new Hooks();

    public GridPage(Browser browser) {
        this.browser = browser;
    }

    @Given("^I am at AppliFashion Homepage for (.*) test$")
    public void IAmAtAppliFashionHomepageForTest(String testName){
        driver = browser.getDriver();
        eyes = browser.getEyes();
        fashionHome = browser.getFashionHome();
        driver.get("https://demo.applitools.com/gridHackathonV1.html");
        eyes.open(driver, "AppliFashion", testName, new RectangleSize(800,600));

    }

    @When("^I do nothing$")
    public void IDoNothing(){

    }

    @Then("^Page should be displayed correctly for step (.*)$")
    public void ThenPageShouldBeDisplayedCorrectlyForStep(String stepName){

        //switch statement is being used here to keep it extesible as more test cases are added we can code specifc
        //behaviour for particular test
        switch (stepName){
            case "Filter Results":
                eyes.check(Target.region(fashionHome.getProductGrid()).withName(stepName));
                break;

            //If we just need full page screenshot, we don't need to write seperate cases for them
            default:
                eyes.check(Target.window().fully().withName(stepName));
        }

        eyes.closeAsync();

    }

    @When("^I apply filter for (.*) shoes$")
    public void IApplyFilterFor(String filter){
        //Check if Black check box is already visible, click it
        //else click the filter button and then the checkbox
        try {
            hooks.explicitWait(driver, 3, fashionHome.getBlackFilterCheckbox());
        } catch (TimeoutException e){
            fashionHome.clickFilterButton();
            hooks.explicitWait(driver, 3, fashionHome.getBlackFilterCheckbox());
        }

        switch (filter){
            case "white":
                fashionHome.clickBlackFilterCheckbox();
        }

        fashionHome.clickApplyFilterButton();
    }

    @When("^I click on first black shoe and product details page is displayed$")
    public void iClickOnFirstBlackShoe(){
        fashionHome.clickFirstBlackShoe();
        hooks.explicitWait(driver, 5, fashionHome.getCartButton());  //make sure product page is opened
    }

}
