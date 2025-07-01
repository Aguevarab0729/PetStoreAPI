package com.globant.test;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import com.globant.config.TestRunner;
import com.globant.model.users.GetUserResponseDTO;
import com.globant.request.RequestBuilder;
import com.globant.model.users.UserDTO;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.entity.ContentType;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

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
                .body("data.id", equalTo(1))
                .body("data.username", equalTo("Angelicagb"))
                .body("data.firstName", equalTo("Angelica"))
                .body("data.lastName", equalTo("Guevara"))
                .body("data.email", equalTo("ag@gmail.com"))
                .body("data.password", equalTo("123456"))
                .body("data.phone", equalTo("1234567890"))
                .body("data.userStatus", equalTo("1"));

    }

    @Test(testName = "Validate found user - assertion 2")
    public void userFoundAssertion2() {
        Response response = RequestBuilder.getRequest(getBaseUrl(), "/users/2", getApiKey());

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
        GetUserResponseDTO getUserResponseDTO = response.as(GetUserResponseDTO.class);

        assertEquals(response.getStatusCode(), 200);
        assertEquals(getUserResponseDTO.getUserDTO().getId(), 2, "The id of the user match with the expected value.");
        assertEquals(getUserResponseDTO.getUserDTO().getFirstName(), "Jannet", "The first name of the user match with the expected value.");
        assertEquals(getUserResponseDTO.getUserDTO().getLastName(), "Vergara", "The first name of the user match with the expected value.");
    }

    /*@Test(testName = "Validate found user - assertion 4")
    public void userFoundAssertion4() {
        Response response = RequestBuilder.getRequest(getBaseUrl(), "/users/2", getApiKey());
        GetUserResponseDTO expectedUser = GetUserResponseDTO.builder()
                .userDTO(UserDTO.builder()
                        .id(2)
                        .firstName("Janet")
                        .lastName("df")
                        .email("jsk@gmail.com")
                        .avatar("https://reqres.in/img/faces/2-image.jpg")
                        .build())
                .build();

        GetUserResponseDTO getUserResponseDTO = response.as(GetUserResponseDTO.class);
        assertEquals(getUserResponseDTO, expectedUser, "The expected user does not match the actual user.");
    }*/

    @Test(testName = "Validate user no found")
    public void userNotFound() {
        Response response = RequestBuilder.getRequest(getBaseUrl(), "/users/23", getApiKey());
        GetUserResponseDTO getUserResponseDTO = response.as(GetUserResponseDTO.class);

        assertEquals(response.getStatusCode(), 404, "The status code does not match the expected value.");
        assertNull(getUserResponseDTO.getUserDTO(), "The user should not be found, but it was returned.");
        //assertEquals(response.getBody().asString(), "Not Found", "The body of the response does not match the expected value.");
    }
}

