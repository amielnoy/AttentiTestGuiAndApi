/**
 * 
 */
package pageObjects.initializePageObjects;

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
	public MainConversionsPage tdmMainPage()
	{
		return PageFactory.initElements(getWebDriver(), MainConversionsPage.class);
	}
}
