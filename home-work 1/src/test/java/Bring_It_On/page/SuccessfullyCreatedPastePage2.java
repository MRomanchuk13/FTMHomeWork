package Bring_It_On.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SuccessfullyCreatedPastePage2 {

    private WebDriver driver;

    public SuccessfullyCreatedPastePage2(WebDriver driver) {
        this.driver = driver;
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.className("info-top")));
        PageFactory.initElements(driver, this);
    }

    public String getPasteName(WebDriver driver) {
        String name = driver.findElement(By.className("info-top")).getText();
        return name;
    }

    public String getPasteLanguage(WebDriver driver) {
        String language = driver.findElement(By.linkText("Bash")).getText();
        return language;
    }

    public String getPasteText(WebDriver driver) {
        String text = driver.findElement(By.className("textarea")).getText();
        return text;
    }
}
