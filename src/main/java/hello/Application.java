package hello;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.gson.Gson;

import backend.geoutils.Authentication;
import ch.qos.logback.classic.Logger;

@SpringBootApplication
public class Application {
	//private static final Logger log = LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) {
    	String tokenStringResult = backend.geoutils.APICalls.getToken();
        Gson gson = new Gson();
        Authentication auth = gson.fromJson(tokenStringResult, Authentication.class);
        SpringApplication.run(Application.class, args);
    }
}
