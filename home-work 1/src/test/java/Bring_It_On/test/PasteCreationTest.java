package Bring_It_On.test;

import Bring_It_On.page.PastebinPage2;
import Bring_It_On.page.SuccessfullyCreatedPastePage2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class PasteCreationTest {

    private WebDriver driver;
    private String text1 = "git config --global user.name  \"New Sheriff in Town\"";
    private String text2 = "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")";
    private String text3 = "git push origin master --force";
    private String name = "how to gain dominance among developers";
    private String text = text1 + text2 + text3;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, SECONDS);
    }

    @Test(description = "Paste creation with current name")
    public void pasteCreationWithCurrentName() {
        String actualName = new PastebinPage2(driver)
                .openPage()
                .pasteCreation(text1, text2, text3, name)
                .getPasteName(driver);

        Assert.assertEquals(actualName, name);
    }

    @Test(description = "Paste creation with current language")
    public void pasteCreationWithCurrentLanguage() {
        String actualLanguage = new PastebinPage2(driver)
                .openPage()
                .pasteCreation(text1, text2, text3, name)
                .getPasteLanguage(driver);

        Assert.assertEquals(actualLanguage, "Bash");
    }

    @Test(description = "Paste creation with current text")
    public void pasteCreationWithCurrentText() {
        String actualText = new PastebinPage2(driver)
                .openPage()
                .pasteCreation(text1, text2, text3, name)
                .getPasteText(driver);

        Assert.assertEquals(actualText, text);
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

}
