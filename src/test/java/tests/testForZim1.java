package tests;

import controllers.BaseMethod;
import controllers.DataProviders.textFileProvider;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.pages.mainPage;

@Test
public class testForZim1 extends BaseMethod {
    @Test
    @Description("Hover above lang selector and extract all language options")
    public void TestHoverAndGetAllLanuageOptions() throws Exception {
        String actualLangugesOption,expectedLanguages;
        expectedLanguages="English\n" +
                "Deutsch\n" +
                "Suomi";
        mainPage currMainPage = new mainPage();
        actualLangugesOption=currMainPage.mouseHover();
        Allure.step("Actual languages="+actualLangugesOption);
        Allure.step("Expected languages="+expectedLanguages);

        Assert.assertEquals(actualLangugesOption,expectedLanguages,"not all the 3 lang's apear");
    }

    @Test(dataProvider = "textFileNameAsMethodName",dataProviderClass= textFileProvider.class)
    @Description("test that languages are chosen validly(english,German....")
    public void TestLanguagesAreChoosedValidly(String expectedLanguage) throws Exception {
        String actualLanguage="ERROR";
        mainPage currMainPage = new mainPage();
        actualLanguage=currMainPage.chooseLanguage(expectedLanguage);

        Allure.step("Actual language="+actualLanguage);
        Allure.step("Expected language="+expectedLanguage);
        Assert.assertEquals(actualLanguage,
                expectedLanguage, "The expected Language & the actual are diffrent!!!");
    }

}
