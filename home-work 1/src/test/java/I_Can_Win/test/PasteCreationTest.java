package I_Can_Win.test;

import I_Can_Win.page.PastebinPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PasteCreationTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "Paste creation with current conditions")
    public void pasteCreation() {
        String expectedText = new PastebinPage(driver)
                .openPage()
                .pasteCreation("Hello from WebDriver", "helloweb")
                .getPasteText(driver);

        Assert.assertEquals(expectedText, "Hello from WebDriver");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

}
