package pageObjects.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import utils.ExplicitWaiting;


public class WeatherComPage extends PageFactoryInitializer {
    protected WebElement tempurtureElement;
    protected String weatherComUrl="https://weather.com/weather/today/l/8d5e48bc01c980a4d0feb2ef2678c978394a463d8381e7c9129d3c10c5e2550e";

    public String getTempByZipCodeTempValue(String zipCode)
    {
        wd.get().navigate().to(weatherComUrl);
        tempurtureElement =getWebDriver().findElement(By.xpath("//*[@id=\"main-Nowcard-92c6937d-b8c3-4240-b06c-9da9a8b0d22b\"]/div/div/section/div[2]/div[1]/div[2]"));
        ExplicitWaiting.driver =getWebDriver();
        ExplicitWaiting.explicitWaitElementToBeClickable(tempurtureElement,10);
        return tempurtureElement.getText().toString();
    }

    public WebElement getTempurtureElement()
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
