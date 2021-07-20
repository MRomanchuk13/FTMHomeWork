package Hurt_Me_Plenty.test;

import Hurt_Me_Plenty.pages.HomePage;
import I_Can_Win.page.PastebinPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EstimationTest {

        private WebDriver driver;

        @BeforeMethod(alwaysRun = true)
        public void browserSetup() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }

        @Test(description = "VM class check")
        public void vmClassCalculation() {
            String vmClass = new HomePage(driver)
                    .openPage()
                    .searchCalculator(driver)
                    .goToCalculator(driver)
                    .calculating()
                    .getVMClass();

            Assert.assertEquals(vmClass, "Regular");
        }

        @AfterMethod(alwaysRun = true)
        public void browserTearDown() {
            driver.quit();
            driver = null;
        }

}
