package tests;

import controllers.BaseMethod;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.pages.UnitToOtherUnitPage;
import pageObjects.pages.MainConversionsPage;

public class testConvertCelsiusToFahrenheit extends BaseMethod {
    @Test
    public void TestConvertCelsiusToFahrenheit() throws Exception {
        String inputCelciusValueToConvertToFaranhiet = "40";

        String actualCelciustoFaranhietResult;
        String expectedCelciustoFaranhietResult = "40°C= 104.0000°F";

        MainConversionsPage currMainConversionsPage = new MainConversionsPage();
        UnitToOtherUnitPage currUnitToOtherUnitPage = new UnitToOtherUnitPage();
        currMainConversionsPage.clickFromConversion();
        currMainConversionsPage.clickFirstTempertureButton();
        currMainConversionsPage.clickSecondTempertureButton();
        currUnitToOtherUnitPage.SetSourceValue(inputCelciusValueToConvertToFaranhiet);
        actualCelciustoFaranhietResult = currUnitToOtherUnitPage.getConversionAnswer();

        Assert.assertEquals(actualCelciustoFaranhietResult,
                expectedCelciustoFaranhietResult, "The expected Faranhiet & the actual are diffrent!!!");
    }

    @Test
    public void TestConvertMetersToFeet() throws Exception {
        String inputMetersValueToConvertToFeet = "10";

        String actualMetersToFeetResult;
        String expectedCelciustoFaranhietResult = "10m= 32ft 9.700788in";

        MainConversionsPage currMainConversionsPage = new MainConversionsPage();
        UnitToOtherUnitPage currUnitToOtherUnitPage = new UnitToOtherUnitPage();
        currMainConversionsPage.clickFromConversion();
        currMainConversionsPage.clickFirstMeterToFeetButton();
        currMainConversionsPage.clickSecondMeterToFeetButton();
        currUnitToOtherUnitPage.SetSourceValue(inputMetersValueToConvertToFeet);
        actualMetersToFeetResult = currUnitToOtherUnitPage.getConversionAnswer();

        Assert.assertEquals(actualMetersToFeetResult,
                expectedCelciustoFaranhietResult, "The expected feet & the actual feet are diffrent!!!");
    }

    @Test
    public void TestConvertOuncesToGrams() throws Exception {
        String inputOuncesValueToGrams = "10";

        String actualOuncesValueToGramsResult;
        String expectedOuncesToGramsResult = "10oz= 283.4952g";

        MainConversionsPage currMainConversionsPage = new MainConversionsPage();
        UnitToOtherUnitPage currUnitToOtherUnitPage = new UnitToOtherUnitPage();
        currMainConversionsPage.clickFromConversion();
        currMainConversionsPage.clickFirstWeightConversionButton();
        currMainConversionsPage.clickSecondOunceToGramsButton();
        currUnitToOtherUnitPage.SetSourceValue(inputOuncesValueToGrams);
        actualOuncesValueToGramsResult = currUnitToOtherUnitPage.getConversionAnswer();

        Assert.assertEquals(actualOuncesValueToGramsResult,
                expectedOuncesToGramsResult, "The expected Grams & the actual are diffrent!!!");
    }
}
