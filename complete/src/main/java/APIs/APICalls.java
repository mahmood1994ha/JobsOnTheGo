package APIs;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class APICalls {

    final private static String googleAPIKey = "AIzaSyCyBMJh5H3ajPaAiqEhg8kkT30cNAQc9o4";


    public  static Location AddressToLocation(String address, String town, String state)
    {
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + address + ",+" + town + ",+" + state + "&key=" + googleAPIKey;

        //AddressLocationResponse response = restTemplate.getForObject(url, AddressLocationResponse.class);

        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET, null, String.class);

        JsonObject jsonObject = new JsonParser().parse(result.getBody()).getAsJsonObject();

        JsonObject geometry = jsonObject.getAsJsonArray("results").get(0).getAsJsonObject().getAsJsonObject("geometry");

        String latitude = geometry.getAsJsonObject("location").getAsJsonPrimitive("lat").getAsString();
        String longitude = geometry.getAsJsonObject("location").getAsJsonPrimitive("lng").getAsString();

        Location location = new Location(latitude, longitude);
        return location;
    }

    /**
     *
     * @param longitude
     * @param latitude
     * @return Returns list of strings with the address fields in order of precision, i.e. : street number then street name, then neighbourhoud, and so On.
     * Concatenate each item to get full address.
     */
    public  static List<String> LocationToAddress(String longitude, String latitude)
    {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://maps.googleapis.com/maps/api/geocode/json?latlng=" + latitude+ "," + longitude + "&key=" + googleAPIKey;

        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET, null, String.class);

        JsonObject jsonObject = new JsonParser().parse(result.getBody()).getAsJsonObject();

        JsonArray addressComponent = jsonObject.getAsJsonArray("results").get(0).getAsJsonObject().getAsJsonArray("address_components");

        List<String> addressFields = new ArrayList<>();

        for (int i = 0; i < addressComponent.size(); i++)
        {
            addressFields.add(addressComponent.get(i).getAsJsonObject().getAsJsonPrimitive("long_name").getAsString());
        }

        return addressFields;
    }

    public static List<Vehicle> getNearestVehicles(int radius, String latitude, String longitude, int count, String token) {
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://node.integrations.mock.goflash.com/partner/vehicles/nearest?count=" + Integer.toString(count) + "&lat=" + latitude + "&long=" + longitude + "&radius=" + Integer.toString(radius);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Api-Version", "1.0");
        headers.add("Authorization", "Bearer " + token);

        HttpEntity<String> request = new HttpEntity<String>(headers);

        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET, request, String.class);

        Gson gson = new Gson();

        System.out.println(result.getBody());

        VehicleResponse vehicles = gson.fromJson(result.getBody(), VehicleResponse.class);

        return vehicles.getVehicles();

    }

    public static void getBusinesses(String token, String longitude, String latitude)
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
