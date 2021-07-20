package Hurt_Me_Plenty.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EstimationPage {

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

    public EstimationPage (WebDriver driver) {
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
}
