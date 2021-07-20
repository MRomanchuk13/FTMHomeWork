package Hurt_Me_Plenty.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultsPage {

    private WebDriver driver;

    @FindBy(className = "gsc-results gsc-webResult")
    WebElement searchResults;

    public SearchResultsPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CalculatorPage goToCalculator(WebDriver driver) {
        searchResults.click();
        return new CalculatorPage(driver);
    }
}
