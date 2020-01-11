package tests;

import controllers.BaseMethod;
import controllers.DataProviders.textFileProvider;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pageObjects.pages.TablePage;

@Test
public class testTableForZim2 extends BaseMethod {

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
