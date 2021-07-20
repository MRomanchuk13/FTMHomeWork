package I_Can_Win.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;

public class SuccessfullyCreatedPastePage {

    private WebDriver driver;

    public SuccessfullyCreatedPastePage (WebDriver driver) {
        this.driver = driver;
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.className("info-top")));
        PageFactory.initElements(driver, this);
    }

    public String getPasteText(WebDriver driver) {
        String text = driver.findElement(By.className("textarea")).getText();
        return text;
    }

}
