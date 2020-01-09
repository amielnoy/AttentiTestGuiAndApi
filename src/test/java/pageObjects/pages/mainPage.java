package pageObjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import utils.ExplicitWaiting;
import io.qameta.allure.Allure;

import org.apache.log4j.Logger;
import utils.seleniumActions;

public class mainPage extends PageFactoryInitializer {
    final static Logger logger = Logger.getLogger(mainPage.class);

    protected WebElement languageSelector =getWebDriver().findElement(By.id("ChooseLanguageDlgOpener"));
    protected WebElement floatingMenu =getWebDriver().findElement(By.id("Col1"));

    public String mouseHover()
    {
        languageSelector =getWebDriver().findElement(By.id("ChooseLanguageDlgOpener"));
        floatingMenu =getWebDriver().findElement(By.id("Col1"));
        ExplicitWaiting.driver =getWebDriver();
        ExplicitWaiting.explicitWaitElementToBeClickable(languageSelector,10);
        //languageSelector.click();
        System.out.println("HOVERING LANG'");
        mousehover(languageSelector);
        //get all the values of the floating menue
        logger.debug("floating menu elements text:"+floatingMenu.getText());
        Allure.description("reporting floating elements after hovering: "+languageSelector.getText());
        return floatingMenu.getText();
    }


    public String chooseLanguage(String language)
    {
        int index=-1;
        String langSelected="ERROR";
        languageSelector =getWebDriver().findElement(By.id("ChooseLanguageDlgOpener"));

        new Actions(getWebDriver()).moveToElement(languageSelector).perform();
        switch(language) {
            case "EN":
                index=1;
                break;
            case "DE":
                index=2;
                break;
            case "FI":
                index=3;
                break;
            default:
                index=-1;
                logger.debug("ERROR: error in language!!!");
        }
        WebElement menuItem=getWebDriver().findElement(By.xpath("//*[@id='Col1']/ul/li["+index+"]/a"));

        ExplicitWaiting.driver =getWebDriver();
        logger.debug("floating menu element= "+menuItem.getText());
        ExplicitWaiting.explicitWaitVisibilityOfElement(menuItem,10);
        menuItem.click();
        languageSelector =getWebDriver().findElement(By.id("ChooseLanguageDlgOpener"));
        ExplicitWaiting.explicitWaitElementToBeClickable(languageSelector,10);
        langSelected=languageSelector.getText();
        logger.debug("language selected= "+langSelected);
        return langSelected;
    }

    public mainPage clickFirstTempertureButton()
    {
        System.out.println("CLICKING BUTTON FIRST TEMPERTURE CONVERSION");
        //seleniumActions.clickButton(WebElementLinkTemperture,"Temperature");
        //WebElement WebElementSecondLinkCelciusToFaranhiet= getWebDriver().findElement(BySecondLinkCelciusToFaranhiet);
        //ExplicitWaiting.explicitWaitVisibilityOfElement(WebElementSecondLinkCelciusToFaranhiet,10);
        return this;
    }

    public mainPage clickFirstMeterToFeetButton()
    {
        System.out.println("CLICKING BUTTON FIRST METER TO FEET CONVERSION");
        //seleniumActions.clickButton(WebElementLinkLength,"Length");
        //WebElement WebElementSecondLinkConvertMetersToFeet= getWebDriver().findElement(BySecondLinkConvertMetersToFeet);
        //ExplicitWaiting.explicitWaitVisibilityOfElement(WebElementSecondLinkConvertMetersToFeet,10);
        return this;
    }

    public mainPage clickFirstWeightConversionButton()
    {
        System.out.println("CLICKING BUTTON FIRST WEIGHT CONVERSION");
        //seleniumActions.clickButton(WebElementLinkWeight,"Weight");
        //WebElement WebElementBySecondLinkConvertOuncesToGrams= getWebDriver().findElement(BySecondLinkConvertOuncesToGrams);
        //ExplicitWaiting.explicitWaitVisibilityOfElement(WebElementBySecondLinkConvertOuncesToGrams,10);
        return this;
    }


    public mainPage clickSecondTempertureButton()
    {
        System.out.println("CLICKING SECOND BUTTON TEMPERTURE CONVERSION");
        //ExplicitWaiting.explicitWaitElementToBeClickable(BySecondLinkCelciusToFaranhiet,3);
        //ExplicitWaiting.clickAndSyncWithNextElement(BySecondLinkCelciusToFaranhiet,"Celsius to Fahrenheit",By.id("argumentConv"),3);
        //waitForJStoLoad();
        return this;
    }

    public mainPage clickSecondMeterToFeetButton()
    {
        System.out.println("CLICKING SECOND BUTTON TEMPERTURE CONVERSION");
        //ExplicitWaiting.explicitWaitElementToBeClickable(BySecondLinkConvertMetersToFeet,3);
        //ExplicitWaiting.clickAndSyncWithNextElement(BySecondLinkConvertMetersToFeet,"Meters to Feet",By.id("argumentConv"),4);
        return this;
    }

    public mainPage clickSecondOunceToGramsButton()
    {
        System.out.println("CLICKING SECOND BUTTON WEIGHT CONVERSION");
        //ExplicitWaiting.explicitWaitElementToBeClickable(BySecondLinkConvertOuncesToGrams,3);
        //ExplicitWaiting.clickAndSyncWithNextElement(BySecondLinkConvertOuncesToGrams,"Ounces to Grams",By.id("argumentConv"),3);
        return this;
    }


    public mainPage verifyPageExsitance() throws Exception
    {
//        println("inputUsernameTextBox.getText()="+inputFromConversion.getText());
//        Assert.assertEquals(inputFromConversion.getText(), "");
        return this;
    }


}
