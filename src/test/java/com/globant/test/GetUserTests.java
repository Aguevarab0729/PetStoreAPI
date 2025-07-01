package com.globant.test;

import com.globant.config.TestRunner;
import com.globant.request.RequestBuilder;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.entity.ContentType;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.Assert.assertEquals;

public class GetUserTests extends TestRunner {
    @Test(testName = "Validate found user - assertion ")
    public void userFoundAssertion() {
        RestAssured
                .given()
                .baseUri(getBaseUrl())
                .header("Content-Type", ContentType.APPLICATION_JSON.getMimeType())
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .when()
                .get()
                .then()
                .body("data.id", equalTo(2))
                .body("data.first_name", equalTo("Janet"))
                .body("data.last_name", equalTo("df"));
    }
    @Test(testName = "Validate found user - assertion 2")
    public void userFoundAssertion2() {
        Response response = RequestBuilder.getRequest(getBaseUrl(), "/users/2", getApiKey());
        /*Response response = RestAssured
                .given()
                .baseUri(getBaseUrl())
                .header("Content-Type", ContentType.APPLICATION_JSON.getMimeType())
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .when()
                .get("/users/2");*/

        JsonPath jsonPath = response.jsonPath();
        Integer id = jsonPath.getInt("data.id");
        String firstName = jsonPath.getString("data.first_name");
        String lastName = jsonPath.getString("data.last_name");

        assertEquals(response.getStatusCode(), 200, "The user doesnt match with the expected value.");
        assertEquals(id, 2);
        assertEquals(firstName, "dfs");
        assertEquals(lastName, "df");
    }

    @Test(testName = "Validate found user - assertion 3")
    public void userFoundAssertion3() {
        Response response = RequestBuilder.getRequest(getBaseUrl(), "/users/2", getApiKey());

        JsonPath jsonPath = response.jsonPath();
        Integer id = jsonPath.getInt("data.id");
        String firstName = jsonPath.getString("data.first_name");
        String lastName = jsonPath.getString("data.last_name");

        assertEquals(response.getStatusCode(), 200, "The user doesnt match with the expected value.");
        assertEquals(id, 2);
        assertEquals(firstName, "Janet");
        assertEquals(lastName, "df");
    }
}

