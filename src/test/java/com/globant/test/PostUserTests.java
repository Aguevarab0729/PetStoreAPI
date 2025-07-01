package com.globant.test;

import com.globant.config.TestRunner;
import com.globant.model.users.CreateUserDTO;
import com.globant.model.users.CreateUserResponseDTO;
import com.globant.request.RequestBuilder;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class PostUserTests extends TestRunner {


    @Test(testName = "Validate user creation")
    public void createUserTest(){
        CreateUserDTO createUserDTO = CreateUserDTO.builder()
                .id("1")
                .username("prueba1")
                .firstName("Angelica")
                .lastName("Guevara")
                .email("ag@gmail.com")
                .password("123456")
                .phone("1234567890")
                .userStatus(1)
                .build();
        Response response = RequestBuilder.postRequest(getBaseUrl(), "/user", getApiKey(), createUserDTO);
        CreateUserResponseDTO createUserResponseDTO = response.as(CreateUserResponseDTO.class);

        assertEquals(response.getStatusCode(), 201, "The status code no match with the expected value.");
        assertEquals(createUserResponseDTO.getUsername(), "prueba1");
        assertEquals(createUserResponseDTO.getFirstName(), "Angelica", "The first name of the user match with the expected value.");
        assertEquals(createUserResponseDTO.getLastName(), "Guevara", "The last name of the user match with the expected value.");
        assertEquals(createUserResponseDTO.getEmail(), "ag@gmail.com", "The email of the user match with the expected value.");
        assertEquals(createUserResponseDTO.getPassword(), "123456", "The password of the user match with the expected value.");
        assertEquals(createUserResponseDTO.getPhone(), "1234567890", "The phone of the user match with the expected value.");
        assertEquals(createUserResponseDTO.getUserStatus(), 1, "The user status of the user match with the expected value.");
        //assertEquals(createUserResponseDTO.getId());
        assertNotNull(createUserResponseDTO.getUsername());

        /*System.out.println(response.getContentType());
        System.out.println(response.getBody().asString());System.out.println(response.getStatusCode());
        System.out.println(response.getContentType());
        System.out.println(response.getBody().asString());*/

    }
}
