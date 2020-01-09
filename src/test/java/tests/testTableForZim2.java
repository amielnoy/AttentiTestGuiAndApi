package tests;

import controllers.ApplicationConfig;
import controllers.BaseMethod;
import controllers.DataProviders.textFileProvider;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.pages.mainPage;
import pageObjects.pages.tablePage;
import pageObjects.pages.unitToOtherUnitPage;

@Test
public class testTableForZim2 extends BaseMethod {
    @Test
    @Description("Hover above lang selector and extract all language options")
    public void TestTableValueSearch() throws Exception {

        tablePage currTablePage = new tablePage();
        WebElement table=getWebDriver().findElement(By.id("customers"));
        String searchText="Germany";

        int returnIndexColumnText=-1;
        String searchColumn="Country";
        boolean actualTableValueSearch=currTablePage.getTableCellText(table,searchColumn,searchText,returnIndexColumnText);

        //Assert.assertEquals(actualLangugesOptions,expectedlanguages,"not all the 3 lang's apear");
    }

    @Test(dataProvider = "textFileNameAsMethodName",dataProviderClass= textFileProvider.class)
    @Description("test that languages are chosen validly(english,German....")
    public void TestLanguagesAreChoosedValidly(String expectedLanguage) throws Exception {
        String actualLanguage="ERROR";
        mainPage currMainPage = new mainPage();
        unitToOtherUnitPage currUnitToOtherUnitPage = new unitToOtherUnitPage();
        actualLanguage=currMainPage.chooseLanguage(expectedLanguage);


        Assert.assertEquals(actualLanguage,
                expectedLanguage, "The expected Language & the actual are diffrent!!!");
    }

}
