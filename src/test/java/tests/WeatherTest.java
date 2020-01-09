package tests;


import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
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

    @Test
    public void testUsingRestAssured(){
        String testApiKey="9ed975128151e2d14e3c956c3ea9ad0f";
        String urlTestOpenWheatherMap="http://api.openweathermap.org/data/2.5/weather?zip=20852,us&units=imperial&APPID="+testApiKey;
        String url="http://restapi.demoqa.com/utilities/weather/city";
        Response response=WebServicesKeywords.getHttpResponceUsingRestAssured(url);
        String responseBody=response.getBody().toString();
        System.out.println("Response Body is =>  " + responseBody);
    }

    @Test
    public void GetWeatherDetails()
    {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

        // Get the RequestSpecification of the request that you want to sent
        // to the server. The server is specified by the BaseURI that we have
        // specified in the above step.
        RequestSpecification httpRequest = RestAssured.given();

        // Make a request to the server by specifying the method Type and the method URL.
        // This will return the Response from the server. Store the response in a variable.
        Response response = httpRequest.request(Method.GET, "/Hyderabad");

        // Now let us print the body of the message to see what response
        // we have recieved from the server
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is =>  " + responseBody);

    }

}

