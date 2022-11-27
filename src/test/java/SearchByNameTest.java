import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import swisstime.pages.CatalogPage;

import static swisstime.pages.constant.PagesURL.*;

public class SearchByNameTest {
    private static WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void initWebDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver.get(CATALOG_PAGE);
        driver.manage().deleteAllCookies();
    }

    @Test
    public void testSearchingByName() {
        CatalogPage catalogPage = new CatalogPage(driver);
        String expectedNameWatch = "T-My Lady Automatic 18k Gold";

        catalogPage.clickSearchButton()
                .typeTextInInput(expectedNameWatch)
                .pause(catalogPage.findRealNameWatch());

        String realNameWatch = catalogPage.findRealNameWatch().getText();
        Assert.assertEquals(realNameWatch, expectedNameWatch);
    }

    @AfterTest
    public void quitDriver() {
        driver.quit();
    }
}
