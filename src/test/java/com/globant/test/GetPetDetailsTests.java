package com.globant.test;

import com.globant.config.TestRunner;
import com.globant.request.RequestBuilder;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GetPetDetailsTests extends TestRunner {
    @Test(testName = "Validate pet details")
    public void getPetDetailsTest() {
        Response response = RequestBuilder.getPetDetailsRequest(getBaseUrl(), "/pet/1", getApiKey());
        assertEquals(response.getStatusCode(), 200);
        assertEquals(response.getContentType(), "application/json", "The content type should be application/json.");
        System.out.println("This test is not yet implemented.");
    }
}
