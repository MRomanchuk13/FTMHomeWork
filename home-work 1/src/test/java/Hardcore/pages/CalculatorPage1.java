package Hardcore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CalculatorPage1 {

    private WebDriver driver;

    @FindBy(className = "name ng-binding")
    WebElement computeEngine;

    @FindBy(id = "input_66")
    WebElement instancesInput;

    @FindBy(id = "select_value_label_59")
    Select softwareSelector;

    @FindBy(id = "select_value_label_60")
    Select vmClass;

    @FindBy(id = "select_value_label_62")
    Select series;

    @FindBy(id = "select_value_label_63")
    Select machineType;

    @FindBy(xpath = "//*[@id=\"mainForm\"]/div[2]/div/md-card/md-card-content/div/div[1]/form/div[9]/div[1]/md-input-container/md-checkbox/div[1]")
    WebElement addGPUCheckbox;

    @FindBy(id = "select_value_label_414")
    WebElement numberOfGPUInput;

    @FindBy(id = "select_value_label_415")
    Select GPUType;

    @FindBy(xpath = "//*[@id=\"select_value_label_376\"]/span[1]")
    Select localSSD;

    @FindBy(xpath = "//*[@id=\"select_value_label_64\"]/span[1]")
    Select datacenterLocation;

    @FindBy(xpath = "//*[@id=\"select_value_label_65\"]/span[1]")
    Select committedUsage;

    @FindBy(xpath = "//*[@id=\"mainForm\"]/div[2]/div/md-card/md-card-content/div/div[1]/form/div[17]/button")
    WebElement addToEstimateButton;

    public CalculatorPage1(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public EstimationPage1 calculating() {
        computeEngine.click();
        instancesInput.sendKeys("4");
        softwareSelector.selectByVisibleText("Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS");
        vmClass.selectByVisibleText("Regular");
        series.selectByVisibleText("N1");
        machineType.selectByVisibleText("n1-standard-8 (vCPUs: 8, RAM: 30 GB)");
        addGPUCheckbox.click();
        numberOfGPUInput.sendKeys("1");
        GPUType.selectByVisibleText("NVIDIA Tesla V100");
        localSSD.selectByVisibleText("2x375 Gb");
        datacenterLocation.selectByVisibleText("Frankfurt (europe-west3)");
        committedUsage.selectByVisibleText("1 Year");
        addToEstimateButton.click();
        return new EstimationPage1(driver);
    }
}
