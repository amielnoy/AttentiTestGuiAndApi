package pageObjects.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import utils.ExplicitWaiting;
import utils.seleniumActions;

import static java.sql.DriverManager.println;


public class UnitToOtherUnitPage extends PageFactoryInitializer {


    public void SetSourceValue(String celceiusValue)
    {
        WebElement inputCelciusToFaranhiet =getWebDriver().findElement(By.id("argumentConv"));
        ExplicitWaiting.driver =getWebDriver();
        ExplicitWaiting.explicitWaitElementToBeClickable(inputCelciusToFaranhiet ,10);
        System.out.println("SETTING VALUE="+celceiusValue);
        inputCelciusToFaranhiet.sendKeys(celceiusValue);
        ExplicitWaiting.explicitWaitElementToBeClickable(inputCelciusToFaranhiet,10);
    }

    public WebElement getInputCelciusToFaranhiet()
    {
        WebElement inputCelciusToFaranhiet =getWebDriver().findElement(By.id("argumentConv"));
        return inputCelciusToFaranhiet;
    }


    public String getConversionAnswer()
    {
        WebElement inputCelciusToFaranhiet =getWebDriver().findElement(By.id("answer"));
        return inputCelciusToFaranhiet.getText();
    }
}
