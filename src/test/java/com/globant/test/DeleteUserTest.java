package com.globant.test;

import com.globant.config.TestRunner;
import com.globant.request.RequestBuilder;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DeleteUserTest extends TestRunner {
    @Test(testName = "Validate user deletion")
    public void deleteUser(){
        Response response = RequestBuilder.deleteRequest(getBaseUrl(), "/user/", getApiKey(), "prueba1");
        assertEquals(response.getStatusCode(), 200, "the user deletion was successful.");

        Response responseInvalid = RequestBuilder.deleteRequest(getBaseUrl(), "/user/", getApiKey(), "usuario_invalido");
        assertEquals(responseInvalid.getStatusCode(), 400, "Invalid username supplied.");

        Response responseNotFound = RequestBuilder.deleteRequest(getBaseUrl(), "/user/", getApiKey(), "usuario_no_existente");
        assertEquals(responseNotFound.getStatusCode(), 404, "User not found.");
    }
}
