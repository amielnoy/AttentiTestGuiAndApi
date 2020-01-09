package pageObjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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


    public mainPage chooseLanguage(String language)
    {
        //"//div[@id='Col1']/ul/li[2]";
        WebElement floatingMenuItem2 =getWebDriver().findElement(By.xpath("//div[@id='Col1']/ul/li[2])"));
        final String EXPECTED_LANGUGES="English\n" +
                "Deutsch\n" +
                "Suomi";

        mouseHover();
        languageSelector =getWebDriver().findElement(By.id("ChooseLanguageDlgOpener"));
        //floatingMenu =getWebDriver().findElement(By.id("Col1"));
        ExplicitWaiting.driver =getWebDriver();
        floatingMenuItem2 =getWebDriver().findElement(By.xpath("//div[@id='Col1']/ul/li[2])"));
        ExplicitWaiting.explicitWaitVisibilityOfElement(floatingMenuItem2,10);

        seleniumActions.clickButton(floatingMenuItem2,EXPECTED_LANGUGES);
        //get all the values of the floating menue
        logger.debug("floating menu elements text:"+floatingMenu.getText());
        Allure.description("reporting floating elements after hovering: "+languageSelector.getText());
        return this;
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
