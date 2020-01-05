package pageObjects.WebServicesUtils;

import io.qameta.allure.Step;
import okhttp3.OkHttpClient;
import okhttp3.Request;

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
}
