package com.ankitnandwani.cucumber.Repo.AppliFashion;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FashionHome {

    public FashionHome(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "INPUTtext____42")
    private WebElement searchBar;

    public WebElement getSearchBar() {
        return searchBar;
    }

    @FindBy(id = "A__btnsearchm__59")
    private WebElement magnifyingGlass;

    public WebElement getMagnifyingGlass() {
        return magnifyingGlass;
    }

    @FindBy(id = "SPAN__checkmark__112")
    private WebElement whiteFilterCheckbox;

    public WebElement getWhiteFilterCheckbox() {
        return whiteFilterCheckbox;
    }

    public void clickWhiteFilterCheckbox() {
        whiteFilterCheckbox.click();
    }

    @FindBy(id = "ti-filter")
    private WebElement filterButton;

    public void clickFilterButton() {
        filterButton.click();
    }

    @FindBy(id = "filterBtn")
    private WebElement applyFilterButton;

    public void clickApplyFilterButton() {
        applyFilterButton.click();
    }

    @FindBy(xpath = "//div[@id='product_grid']/div")
    private List<WebElement> numberOfItems;

    public int getNumberOfItems() {
        return numberOfItems.size();
    }


}
