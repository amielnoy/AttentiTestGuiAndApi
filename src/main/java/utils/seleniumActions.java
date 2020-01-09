package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class seleniumActions extends ExplicitWaiting {
        public static void  clickButton(By currentBy,String textToBeVisible){
        ExplicitWaiting.driver =getWebDriver();
        WebElement currentWebElement=getWebDriver().findElement(currentBy);
        ExplicitWaiting.explicitWaitElementToBeClickable(currentWebElement,10);
        ExplicitWaiting.explicitWaitTextToBePresentInElement(currentWebElement,10,textToBeVisible);
        System.out.println("CLICKING WEB ELEMENT(USING BY)"+currentWebElement.getText());
        currentWebElement.click();
    }



    public static void  clickButton(WebElement currentWebElement,String textToBeVisible){
        ExplicitWaiting.driver =getWebDriver();
        ExplicitWaiting.explicitWaitElementToBeClickable(currentWebElement,10);
        ExplicitWaiting.explicitWaitTextToBePresentInElement(currentWebElement,10,textToBeVisible);
        System.out.println("CLICKING WEB ELEMENT"+currentWebElement.getText());
        currentWebElement.click();
    }
}
