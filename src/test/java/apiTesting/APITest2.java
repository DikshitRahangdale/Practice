package apiTesting;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class APITest2 {

	@Test
	public void test() {

		given()

				.when().header("x-api-key", "reqres_e9685bce135a467985a13df17571b229")
				.get("https://reqres.in/api/collections/products/records/675c7d44-e239-4ae8-ac74-ae26c4b82c86?project_id=39048")

				.then().statusCode(200).body("data.project_id", equalTo(39048)).log().all();
	}

	@Test(priority = 1)
	public void createUser() {
		String requestBody = """
				{
				    "name": "Iphone Devices",
				    "price": 7508700,
				    "category": "Electronics",
				    "in_stock": true
				}
				""";
		given().header("x-api-key", "reqres_e9685bce135a467985a13df17571b229").contentType("application/json")
				.body(requestBody)

				.when().post("https://reqres.in/api/api/register")

				.then().log().all();
	}

}
