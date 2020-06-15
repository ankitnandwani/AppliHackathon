package com.ankitnandwani.cucumber.StepDefs;

import com.ankitnandwani.cucumber.Browser;
import com.ankitnandwani.cucumber.Hooks;
import com.ankitnandwani.cucumber.Repo.AppliFashion.FashionHome;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Properties;

public class GridPage {

    private Browser browser;
    private WebDriver driver;
    private FashionHome fashionHome;
    private  String mode;
    private String browserInstance;
    private String viewport;
    Hooks hooks = new Hooks();


    public GridPage(Browser browser) {
        this.browser = browser;
    }

    @Given("^I run the test on (.*) with (.*) and (.*)$")
    public void IRunTheTestOn(String _browserInstance, String _width, String _height){
        browserInstance = _browserInstance;
        viewport = _width + "x" + _height;
        driver = browser.getDriver(_browserInstance, _width, _height);
    }

    @And("^I am at AppliFashion Homepage for (.*) test in (.*)$")
    public void IAmAtAppliFashionHomepageForTestIn(String testName, String _mode){
        mode = _mode;
        fashionHome = new FashionHome(driver);
        driver.get("https://demo.applitools.com/gridHackathonV1.html");

    }

    @When("^I do nothing$")
    public void IDoNothing(){

    }

    @Then("^SearchBar should be displayed correctly$")
    public void SearchBarShouldBeDisplayedCorrectly(){
        SoftAssertions softly = new SoftAssertions();
        switch (mode){
            case "laptop":
            case "tablet":
                //make sure search bar is displayed in tablet mode
                //make sure search bar is displayed in laptop mode
                softly.assertThat(hooks.hackathonReporter(1
                        , "SearchBar"
                        , fashionHome.getSearchBar().getAttribute("id")
                        , fashionHome.getSearchBar().isEnabled()
                        , browserInstance
                        , viewport
                        , mode)).isTrue();

                break;

            case "mobile":
                //make sure search bar is NOT displayed in mobile mode
                softly.assertThat(hooks.hackathonReporter(1
                        , "SearchBar"
                        , fashionHome.getSearchBar().getAttribute("id")
                        , fashionHome.getSearchBar().isEnabled()
                        , browserInstance
                        , viewport
                        , mode)).isFalse();

                break;
        }

        softly.assertAll();
    }

    @Then("^Magnifying glass should be displayed correctly$")
    public void MagnifyingGlassShouldBeDisplayedCorrectly(){
        SoftAssertions softly = new SoftAssertions();
        switch (mode){
            case "laptop":
            case "tablet":

                //make sure Magnifying glass of mobile is NOT displayed in laptop mode
                softly.assertThat(hooks.hackathonReporter(1
                        , "Magnifying glass"
                        , fashionHome.getMagnifyingGlass().getAttribute("id")
                        , fashionHome.getMagnifyingGlass().isEnabled()
                        , browserInstance
                        , viewport
                        , mode)).isFalse();

                break;

            case "mobile":

                //make sure Magnifying glass is displayed in mobile mode
                softly.assertThat(hooks.hackathonReporter(1
                        , "Magnifying glass"
                        , fashionHome.getMagnifyingGlass().getAttribute("id")
                        , fashionHome.getMagnifyingGlass().isEnabled()
                        , browserInstance
                        , viewport
                        , mode)).isTrue();

                break;
        }

        softly.assertAll();
    }

    @When("^I click the (.*) filter$")
    public void iClickTheWhiteFilter(String filter){

        try {
            hooks.explicitWait(driver, 3, fashionHome.getWhiteFilterCheckbox());
        } catch (TimeoutException e){
            fashionHome.clickFilterButton();
            hooks.explicitWait(driver, 3, fashionHome.getWhiteFilterCheckbox());
        }

        switch (filter){
            case "white":
                fashionHome.clickWhiteFilterCheckbox();
        }

        fashionHome.clickApplyFilterButton();

    }

    @Then("^only white shoes should be displayed$")
    public void onlyWhiteShoesShouldBeDisplayed(){
        SoftAssertions softly = new SoftAssertions();
        switch (mode){
            case "laptop":
            case "tablet":
            case "mobile":

                //make sure only 1 shoe is displayed for white
                softly.assertThat(hooks.hackathonReporter(1
                        , "Filter"
                        , fashionHome.getWhiteFilterCheckbox().getAttribute("id")
                        , fashionHome.getNumberOfItems() == 1
                        , browserInstance
                        , viewport
                        , mode)).isTrue();

                break;
        }

        softly.assertAll();
    }
}
