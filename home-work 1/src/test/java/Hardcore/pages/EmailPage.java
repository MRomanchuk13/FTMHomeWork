package Hardcore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailPage {

    private static final String PAGE_URL = "https://10minutemail.com/";
    private WebDriver driver;

    @FindBy(xpath = "//*[@class=\"copy_icon\"]")
    private WebElement copyEmail;

    @FindBy(xpath = "//*[@class=\"message_top\"]")
    private WebElement emailBody;

    @FindBy(xpath = "//*[@id=\"mobilepadding\"]/td/table/tbody/tr[2]/td[2]/h3")
    private WebElement estimationPrice;

    public EmailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public EstimationPage1 setEmail(WebDriver driver) {
        copyEmail.click();
        return new EstimationPage1(driver);
    }

    public String getEstimationFromEmail(WebDriver driver) {
        emailBody.click();
        String emailEstimationPrice = estimationPrice.getText();
        return emailEstimationPrice;
    }
}
