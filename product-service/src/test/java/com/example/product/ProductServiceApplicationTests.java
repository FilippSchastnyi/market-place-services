package com.example.product;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {

	// @ServiceConnection annotation is used to inject the MongoDBContainer instance into the test class.
	@ServiceConnection
	static MongoDBContainer mongoDbContainer = new MongoDBContainer(DockerImageName.parse("mongo:7.0.5"));

	@LocalServerPort
	private Integer port;

	@BeforeEach
	void setup() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}

	static {
		mongoDbContainer.start();
	}

	@Test
	void shouldCreateProduct() {
		String requestBody = """
				{
				    "name": "Iphone 16",
				    "description": "New Iphone 16 is already in the stock!",
				    "price": 1432
				}
				""";
		RestAssured.given()
				.contentType("application/json")
				.body(requestBody)
				.when().post("/api/product")
				.then().statusCode(201)
				.body("id", Matchers.notNullValue())
				.body("name", Matchers.equalTo("Iphone 16"))
				.body("description", Matchers.equalTo("New Iphone 16 is already in the stock!"))
				.body("price", Matchers.equalTo(1432));
	}

}
