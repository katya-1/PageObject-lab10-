package swisstime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    private WebDriver webDriver;

    public ProductPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(className = "secondary") //я пыталась сами по сиэсэсу делай касруга
    WebElement addToCartButton;

    @FindBy(xpath = "//a[@href='/cart/']")
    WebElement toCartButton;

    public ProductPage clickGoToCart() {
        toCartButton.click();
        return this;
    }

    public ProductPage clickAddToCartButton() {
        addToCartButton.click();
        return this;
    }

    public WebElement getToCartButton() {
        return toCartButton;
    }

    public ProductPage pause(WebElement webElement) {
        new WebDriverWait(webDriver, Duration.ofMillis(10000)).until(ExpectedConditions.elementToBeClickable(webElement));
        return this;
    }
}
