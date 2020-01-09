/**
 * 
 */
package pageObjects.initializePageObjects;

import controllers.ApplicationConfig;
import org.openqa.selenium.support.PageFactory;

import controllers.BaseMethod;
import pageObjects.pages.*;

/**
 * @author ${Gladson Antony}
 * @date Sep 17, 2016
 * 
 */

public class PageFactoryInitializer extends BaseMethod 
{
	public mainPage mainPage()
	{
		return PageFactory.initElements(getWebDriver(), mainPage.class);
	}
	public tablePage tablePage()
	{
		getWebDriver().navigate().to("http://www.w3schools.com/html/html_tables.asp");
		//ApplicationConfig.setWebsiteUrl("http://www.w3schools.com/html/html_tables.asp");
		return PageFactory.initElements(getWebDriver(), tablePage.class);
	}
}
