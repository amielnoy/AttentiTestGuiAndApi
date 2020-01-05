package pageObjects.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import utils.ExplicitWaiting;
import utils.seleniumActions;

import static java.sql.DriverManager.println;


public class mainConversionsPage  extends PageFactoryInitializer {
    protected WebElement inputFromConversion =getWebDriver().findElement(By.id("queryFrom"));
    protected WebElement inputToConversion =getWebDriver().findElement(By.id("queryTo"));

    protected WebElement WebElementLinkTemperture=getWebDriver().findElement(By.xpath("//*[@id='typeMenu']/a[1]"));
    protected By BySecondLinkCelciusToFaranhiet = By.xpath("//*[@id='popLinks']/ol/li[1]/a");

    protected WebElement WebElementLinkLength=getWebDriver().findElement(By.xpath("//*[@id='typeMenu']/a[3]"));
    protected By BySecondLinkConvertMetersToFeet= By.xpath("//ol/li[1]/a[text()='Meters to Feet']");

    protected WebElement WebElementLinkWeight=getWebDriver().findElement(By.xpath("//*[@id='typeMenu']/a[2]"));
    //*[@id="popLinks"]/ol/li[5]/a
    //*[@id="popLinks"]/ol/li[5]/a
    protected By BySecondLinkConvertOuncesToGrams= By.xpath("//ol/li[5]/a[text()='Ounces to Grams']");
    public mainConversionsPage clickFromConversion()
    {
        inputFromConversion =getWebDriver().findElement(By.id("queryFrom"));
        ExplicitWaiting.driver =getWebDriver();
        ExplicitWaiting.explicitWaitElementToBeClickable(inputFromConversion,10);
        System.out.println("CLICKING FROM CONVERSION");
        inputFromConversion.click();
        return this;
    }

    public mainConversionsPage clickFirstTempertureButton()
    {
        System.out.println("CLICKING BUTTON FIRST TEMPERTURE CONVERSION");
        seleniumActions.clickButton(WebElementLinkTemperture,"Temperature");
        WebElement WebElementSecondLinkCelciusToFaranhiet= getWebDriver().findElement(BySecondLinkCelciusToFaranhiet);
        ExplicitWaiting.explicitWaitVisibilityOfElement(WebElementSecondLinkCelciusToFaranhiet,10);
        return this;
    }

    public mainConversionsPage clickFirstMeterToFeetButton()
    {
        System.out.println("CLICKING BUTTON FIRST METER TO FEET CONVERSION");
        seleniumActions.clickButton(WebElementLinkLength,"Length");
        WebElement WebElementSecondLinkConvertMetersToFeet= getWebDriver().findElement(BySecondLinkConvertMetersToFeet);
        ExplicitWaiting.explicitWaitVisibilityOfElement(WebElementSecondLinkConvertMetersToFeet,10);
        return this;
    }

    public mainConversionsPage clickFirstWeightConversionButton()
    {
        System.out.println("CLICKING BUTTON FIRST WEIGHT CONVERSION");
        seleniumActions.clickButton(WebElementLinkWeight,"Weight");
        WebElement WebElementBySecondLinkConvertOuncesToGrams= getWebDriver().findElement(BySecondLinkConvertOuncesToGrams);
        ExplicitWaiting.explicitWaitVisibilityOfElement(WebElementBySecondLinkConvertOuncesToGrams,10);
        return this;
    }


    public mainConversionsPage clickSecondTempertureButton()
    {
        System.out.println("CLICKING SECOND BUTTON TEMPERTURE CONVERSION");
        ExplicitWaiting.explicitWaitElementToBeClickable(BySecondLinkCelciusToFaranhiet,3);
        ExplicitWaiting.clickAndSyncWithNextElement(BySecondLinkCelciusToFaranhiet,"Celsius to Fahrenheit",By.id("argumentConv"),3);
        //waitForJStoLoad();
        return this;
    }

    public mainConversionsPage clickSecondMeterToFeetButton()
    {
        System.out.println("CLICKING SECOND BUTTON TEMPERTURE CONVERSION");
        ExplicitWaiting.explicitWaitElementToBeClickable(BySecondLinkConvertMetersToFeet,3);
        ExplicitWaiting.clickAndSyncWithNextElement(BySecondLinkConvertMetersToFeet,"Meters to Feet",By.id("argumentConv"),4);
        return this;
    }

    public mainConversionsPage clickSecondOunceToGramsButton()
    {
        System.out.println("CLICKING SECOND BUTTON WEIGHT CONVERSION");
        ExplicitWaiting.explicitWaitElementToBeClickable(BySecondLinkConvertOuncesToGrams,3);
        ExplicitWaiting.clickAndSyncWithNextElement(BySecondLinkConvertOuncesToGrams,"Ounces to Grams",By.id("argumentConv"),3);
        return this;
    }


    public mainConversionsPage verifyPageExsitance() throws Exception
    {
        println("inputUsernameTextBox.getText()="+inputFromConversion.getText());
        Assert.assertEquals(inputFromConversion.getText(), "");
        return this;
    }


}
