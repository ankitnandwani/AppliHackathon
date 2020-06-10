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

    @FindBy(id = "SPAN__checkmark__107")
    private WebElement blackFilterCheckbox;

    public WebElement getBlackFilterCheckbox() {
        return blackFilterCheckbox;
    }

    public void clickBlackFilterCheckbox() {
        blackFilterCheckbox.click();
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

    @FindBy(id = "product_grid")
    private WebElement productGrid;

    public WebElement getProductGrid() {
        return productGrid;
    }

    @FindBy(xpath = "//div[@id='product_grid']/div/div/a")
    private WebElement firstShoe;

    public void clickFirstBlackShoe(){
        firstShoe.click();
    }

    @FindBy(id = "A__btn__114")
    private WebElement cartButton;

    public WebElement getCartButton() {
        return cartButton;
    }
}
