package Hardcore.test;

import Hardcore.pages.HomePage1;
import Hurt_Me_Plenty.pages.HomePage;
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
            String actualEstimationFromEmail = new HomePage1(driver)
                    .openPage()
                    .searchCalculator(driver)
                    .goToCalculator(driver)
                    .calculating()
                    .goToEmailPage(driver)
                    .setEmail(driver)
                    .sendEstimationByEmail(driver)
                    .getEstimationFromEmail(driver);

            String actualEstimation = new HomePage1(driver)
                    .openPage()
                    .searchCalculator(driver)
                    .goToCalculator(driver)
                    .calculating()
                    .getEstimatedCost();

           Assert.assertEquals(actualEstimationFromEmail, actualEstimation);
        }

        @AfterMethod(alwaysRun = true)
        public void browserTearDown() {
            driver.quit();
            driver = null;
        }

}
