package I_Can_Win.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinPage {

    private static final String PAGE_URL = "https://pastebin.com/";
    private WebDriver driver;

    @FindBy(id = "postform-text")
    private WebElement textInput;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement pasteExpirationSelector;

    @FindBy(id = "select2-postform-expiration-results")
    private WebElement pasteExpirationDropdown;

    @FindBy(xpath = "//li[text()='10 Minutes']")
    private WebElement pasteExpirationTime;

    @FindBy(id = "postform-name")
    private WebElement pasteName;

    @FindBy(xpath = "//*[@id=\"w0\"]/div[5]/div[1]/div[8]/button")
    private WebElement createNewPasteButton;

    public PastebinPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PastebinPage openPage() {
        driver.get(PAGE_URL);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("postform-text")));
        return this;
    }

    public SuccessfullyCreatedPastePage pasteCreation(String text, String name) {
        textInput.sendKeys(text);
        pasteExpirationSelector.click();
        pasteExpirationTime.click();
        pasteName.sendKeys(name);
        createNewPasteButton.click();
        return new SuccessfullyCreatedPastePage(driver);
    }
}
