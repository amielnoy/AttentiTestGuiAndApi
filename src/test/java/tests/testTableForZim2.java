package tests;

import controllers.ApplicationConfig;
import controllers.BaseMethod;
import controllers.DataProviders.textFileProvider;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.pages.TablePage;

@Test
public class testTableForZim2 extends BaseMethod {
    @BeforeMethod
    public void  setup(){
        ApplicationConfig.setWebsiteUrl("http://www.w3schools.com/html/html_tables.asp");
        WebsiteURL = appConfig.getWebsiteUrl();
    }
    @Test(dataProvider = "textFileNameAsMethodName",dataProviderClass= textFileProvider.class)
    @Description("test that string values exist in the table")
    public void testTableElementsText(String tableColumnName,String valueToSearchInColumn,String expectedTableCellValue) {
        TablePage tablePage=new TablePage();
        WebElement tableWebElement=getWebDriver().findElement(By.id("customers"));
        try {
            tablePage.verifyTableCellText(tableWebElement, tableColumnName, valueToSearchInColumn, expectedTableCellValue, expectedTableCellValue);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }


}
