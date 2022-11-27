package swisstime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CatalogPage {

    private WebDriver webDriver;

    public CatalogPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = ".search")
    WebElement searchButton;

    @FindBy(id = "title-search-input")
    WebElement inputLine;

    @FindBy(css = ".header-search-result .st-card__model")
    WebElement realNameWatch;

    public CatalogPage clickSearchButton() {
        searchButton.click();
        return this;
    }

    public CatalogPage typeTextInInput(String keys) {
        inputLine.sendKeys(keys);
        return this;
    }

    public CatalogPage pause(WebElement webElement) {
        new WebDriverWait(webDriver, Duration.ofMillis(5000)).until(ExpectedConditions.elementToBeClickable(webElement));
        return this;
    }

    public WebElement findRealNameWatch() {
        return realNameWatch;
    }
}
