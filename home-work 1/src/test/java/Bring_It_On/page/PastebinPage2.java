package Bring_It_On.page;

import I_Can_Win.page.SuccessfullyCreatedPastePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinPage2 {

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

    @FindBy(id = "select2-postform-format-container")
    private WebElement syntaxHighlightingSelector;

    @FindBy(id = "select2-postform-format-result-zvao-1")
    private WebElement syntaxHighlightingDropdown;

    @FindBy(xpath = "//li[text()='Bash']")
    private WebElement syntaxHighlightingLanguage;

    @FindBy(id = "postform-name")
    private WebElement pasteName;

    @FindBy(xpath = "//*[@id=\"w0\"]/div[5]/div[1]/div[8]/button")
    private WebElement createNewPasteButton;

    public PastebinPage2(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PastebinPage2 openPage() {
        driver.get(PAGE_URL);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("postform-text")));
        return this;
    }

    public SuccessfullyCreatedPastePage2 pasteCreation(String text1, String text2, String text3, String name) {
        textInput.sendKeys(text1);
        textInput.sendKeys(Keys.ENTER);
        textInput.sendKeys(text2);
        textInput.sendKeys(Keys.ENTER);
        textInput.sendKeys(text3);
        textInput.sendKeys(Keys.ENTER);
        syntaxHighlightingSelector.click();
        syntaxHighlightingLanguage.click();
        pasteExpirationSelector.click();
        pasteExpirationTime.click();
        pasteName.sendKeys(name);
        createNewPasteButton.click();
        return new SuccessfullyCreatedPastePage2(driver);
    }
}
