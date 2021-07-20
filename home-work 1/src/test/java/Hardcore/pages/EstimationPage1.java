package Hardcore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EstimationPage1 {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"compute\"]/md-list/md-list-item[2]/div")
    WebElement VMClassCheck;

    @FindBy(xpath = "//*[@id=\"compute\"]/md-list/md-list-item[3]/div")
    WebElement instanceTypeCheck;

    @FindBy(xpath = "//*[@id=\"compute\"]/md-list/md-list-item[4]/div")
    WebElement regionCheck;

    @FindBy(xpath = "//*[@id=\"compute\"]/md-list/md-list-item[5]/div")
    WebElement localSSDCheck;

    @FindBy(xpath = "//*[@id=\"resultBlock\"]/md-card/md-card-content/div/div/div/h2/b")
    WebElement estimatedCost;

    @FindBy(className = "md-raised md-primary cpc-button md-button md-ink-ripple")
    WebElement sendEmail;

    @FindBy(xpath = "//*[@id=\"input_508\"]")
    WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"dialogContent_514\"]/form/md-dialog-actions/button[2]")
    WebElement sendEmailButton;


    public EstimationPage1(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getVMClass() {
        String VMClassActual = VMClassCheck.getText();
        return VMClassActual;
    }

    public String getInstanceType() {
        String instanceTypeActual = instanceTypeCheck.getText();
        return instanceTypeActual;
    }

    public String getRegion() {
        String regionActual = regionCheck.getText();
        return regionActual;
    }

    public String getLocalSSD() {
        String localSSDActual = localSSDCheck.getText();
        return localSSDActual;
    }

    public String getEstimatedCost() {
        String estimatedCostActual = estimatedCost.getText();
        return estimatedCostActual;
    }

    public EmailPage goToEmailPage(WebDriver driver) {
        sendEmail.click();
        return new EmailPage(driver);
    }

    public EmailPage sendEstimationByEmail(WebDriver driver) {
        emailInput.sendKeys();
        sendEmailButton.click();
        return new EmailPage(driver);
    }
}
