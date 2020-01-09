package tests;

import controllers.BaseMethod;
import controllers.DataProviders.textFileProvider;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.pages.unitToOtherUnitPage;
import pageObjects.pages.mainPage;

@Test
public class testForZim1 extends BaseMethod {
    @Test
    @Description("Hover above lang selector and extract all language options")
    public void TestHoverAndGetAllLanuageOptions() throws Exception {
        String actualLangugesOptions,expectedlanguages;
        expectedlanguages="English\n" +
                "Deutsch\n" +
                "Suomi";
        mainPage currMainPage = new mainPage();
        unitToOtherUnitPage currUnitToOtherUnitPage = new unitToOtherUnitPage();
        actualLangugesOptions=currMainPage.mouseHover();

        Assert.assertEquals(actualLangugesOptions,expectedlanguages,"not all the 3 lang's apear");
    }

    @Test(dataProvider = "textFileNameAsMethodName",dataProviderClass= textFileProvider.class)
    @Description("test that languages are chosen validly(english,German....")
    public void TestLanguagesAreChoosedValidly(String language) throws Exception {
        mainPage currMainPage = new mainPage();
        unitToOtherUnitPage currUnitToOtherUnitPage = new unitToOtherUnitPage();
        currMainPage.chooseLanguage(language);


//        Assert.assertEquals(actualCelciustoFaranhietResult,
//                expectedCelciustoFaranhietResult, "The expected Faranhiet & the actual are diffrent!!!");
    }

}
