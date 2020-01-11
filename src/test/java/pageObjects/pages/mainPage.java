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
        menuItem=getWebDriver().findElement(By.xpath("//*[@id='Col1']/ul/li["+index+"]/a"));
        menuItem.click();
        languageSelector =getWebDriver().findElement(By.id("ChooseLanguageDlgOpener"));
        ExplicitWaiting.explicitWaitElementToBeClickable(languageSelector,10);
        langSelected=languageSelector.getText();
        logger.debug("language selected= "+langSelected);
        return langSelected;
    }
}
