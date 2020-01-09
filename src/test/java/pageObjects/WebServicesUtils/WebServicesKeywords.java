package pageObjects.WebServicesUtils;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebServicesKeywords {
    public static String getHttpResponse(String url) throws IOException {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        System.out.println("Response Code :: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) { // connection ok
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();
            System.out.println(response.toString());
            return response.toString();
        } else {
            System.out.println("");
            return "";
        }
    }

    public static io.restassured.response.Response getHttpResponceUsingRestAssured(String url)
    {
            // Specify the base URL to the RESTful web service
            RestAssured.baseURI = url;//"http://restapi.demoqa.com/utilities/weather/city";

            // Get the RequestSpecification of the request that you want to sent
            // to the server. The server is specified by the BaseURI that we have
            // specified in the above step.
            RequestSpecification httpRequest = RestAssured.given();

            // Make a request to the server by specifying the method Type and the method URL.
            // This will return the Response from the server. Store the response in a variable.
            Response response = httpRequest.request(Method.GET, "/Hyderabad");
            return response;
        }
}
