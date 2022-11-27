import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import swisstime.pages.CartPage;
import swisstime.pages.ProductPage;

import static swisstime.pages.constant.PagesURL.*;

public class CartCheckTest {
    private static WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void initWebDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver.get(PRODUCT_PAGE);
    }

    @Test
    public void testAdditionToCart() {
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);
        String expectedProductSKU = "Артикул: T143.410.11.091.00";

        productPage.clickAddToCartButton().pause(productPage.getToCartButton()).clickGoToCart();

        String productSKU = cartPage.getProductSKU().getText();

        Assert.assertEquals(productSKU, expectedProductSKU);
    }

    @AfterTest
    public void quitDriver() {
        driver.quit();
    }
}
