package tests;


import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.WebServicesUtils.WebServicesKeywords;

import java.io.IOException;


import static io.qameta.allure.Allure.step;


public class WeatherTest  {
    @Test(priority = 0, description = "Get the updated upload report to flicker site\n" +
            "using OkHttp")
    public void uploadStatus() {
        step("produce request");
        //*********************
        //Using Open weather
        //**********************
        String testApiKey="9ed975128151e2d14e3c956c3ea9ad0f";
        String urlTestOpenWheatherMap="http://api.openweathermap.org/data/2.5/weather?zip=20852,us&units=imperial&APPID="+testApiKey;

        /*the url to use for getting the temp from weather.com
        in Fahrenheit
         */
        String weatherComUrl="https://weather.com/weather/today/l/8d5e48bc01c980a4d0feb2ef2678c978394a463d8381e7c9129d3c10c5e2550e";
        float weatherComTemp=37f;//temperature in Fahrenheit use units=imperial

        step("produce responce");
        try {
            String response = WebServicesKeywords.getHttpResponse(urlTestOpenWheatherMap);
            //validate the responce is not null
            Assert.assertNotNull(response, "echo responce is null/empty!!");
            JSONParser parser = new JSONParser();
            JSONObject responceDetails = (JSONObject) parser.parse(response.toString());
            System.out.println("*** Starting Hard asserting!!will verify every assert and throw exception when assert failes***");
            Assert.assertTrue(responceDetails.get("main").toString().contains("temp"), "main section(tempertures)");
            JSONObject responceDetailsMain= (JSONObject) responceDetails.get("main");
            float temp=Float.valueOf(responceDetailsMain.get("temp").toString());
            System.out.println("temp="+temp);
            step("verify the two temps differ<=10%");
            Assert.assertTrue(100*(temp-weatherComTemp)/100<=10, "main section(tempertures)");
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }




}

