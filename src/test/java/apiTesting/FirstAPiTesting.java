package apiTesting;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class FirstAPiTesting {

	@Test
	public void verifyPost() {

		given()

				.when().get("https://jsonplaceholder.typicode.com/posts/1")

				.then().statusCode(200).body("id", equalTo(1)).body("userId", equalTo(1))
				.body("title", not(emptyString()));
	}

}
