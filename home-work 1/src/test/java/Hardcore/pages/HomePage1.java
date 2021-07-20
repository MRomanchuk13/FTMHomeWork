package Hardcore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage1 {

    private static final String PAGE_URL = "https://cloud.google.com/";
    private WebDriver driver;

    @FindBy (xpath = "//*[@class=\"devsite-searchbox\"]/input")
    WebElement search;

    @FindBy (xpath = "//*[@class=\"devsite-top-logo-row-middle\"]/devsite-search")
    WebElement searchInput;

    @FindBy (className = "devsite-search-form")
    Select calculator;

    public HomePage1(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage1 openPage() {
        driver.get(PAGE_URL);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("devsite-searchbox")));
        return this;
    }

    public SearchResultsPage1 searchCalculator(WebDriver driver) {
        search.click();
//        searchInput.click();
        searchInput.sendKeys("Google Cloud Platform Pricing Calculator");
        calculator.selectByVisibleText("Google Cloud Platform Pricing Calculator");
        return new SearchResultsPage1(driver);
    }
}
