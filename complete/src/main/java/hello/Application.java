package hello;
import APIs.APICalls;
import APIs.Authentication;
import APIs.Vehicle;
import com.google.gson.Gson;
import com.sun.javafx.fxml.builder.URLBuilder;
import com.sun.org.apache.xml.internal.utils.URI;
import jdk.nashorn.internal.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String args[]) {
        //getData("61624a9c-311e-49ab-96d0-29e533d2097f", "13.41053", "52.52437");

        String tokenStringResult = APICalls.getToken();

        Gson gson = new Gson();

        Authentication auth = gson.fromJson(tokenStringResult, Authentication.class);

        List<Vehicle> vehicles = APICalls.getNearestVehicles(250, "13.41053", "52.52437", 3, auth.getAccess_token());

        APICalls.LocationToAddress("106.688451", "10.778411");

        //log.info(quote);
    }

    public static void getData(String token, String longitude, String latitude)
    {
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://node.integrations.mock.goflash.com/partner/areas/business?lat=" + latitude + "&long=" + longitude;

        HttpHeaders headers = new HttpHeaders();
        headers.add("Api-Version", "1.0");
        headers.add("Authorization", "Bearer " + token);

        HttpEntity<String> request = new HttpEntity<String>(headers);

        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET, request, String.class);

        System.out.println(result);
    }

    public static String getToken()
    {
        RestTemplate restTemplate = new RestTemplate();
        String clientID = "dortstdt.3CnyFG68weq7";
        String clientSecret = "sPwz9T4R4bBV274B";
        String grantType = "client_credentials";

        //String quote = restTemplate.getForObject("https://maps.googleapis.com/maps/api/geocode/json?latlng=40.714224,-73.961452&key=AIzaSyCyBMJh5H3ajPaAiqEhg8kkT30cNAQc9o4", String.class);
        final String url = "https://node.integrations.mock.goflash.com/partner/oauth/token?client_id=" + clientID + "&client_secret=" + clientSecret + "&grant_type=" + grantType;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/x-www-form-urlencoded");

        HttpEntity<String> request = new HttpEntity<String>(headers);

        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.POST, request, String.class);

        System.out.println(result.toString());

        return result.getBody();
    }

}