import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;

public class Main {

	@Test
	public void main() {

		RestAssured.baseURI = "https://maps.googleapis.com";

		given().param("location", "-33.8670522,151.1957362").param("radius", "500").param("name", "harbour")
				.param("key", "AIzaSyBTCkTauC4tCfTTLKcjowo-0Y8HWqA4Gfc").when().get("maps/api/place/nearbysearch/json")
				.then().assertThat().statusCode(200).and().body("results[0].name", equalTo("Harbour Bar & Kitchen"));

	}

}