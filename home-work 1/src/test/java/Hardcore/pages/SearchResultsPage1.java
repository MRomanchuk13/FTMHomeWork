package Hardcore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage1 {

    private WebDriver driver;

    @FindBy(className = "gsc-results gsc-webResult")
    WebElement searchResults;

    public SearchResultsPage1(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CalculatorPage1 goToCalculator(WebDriver driver) {
        searchResults.click();
        return new CalculatorPage1(driver);
    }
}
