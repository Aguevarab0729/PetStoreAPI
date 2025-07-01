package com.globant.test;

import com.globant.config.TestRunner;
import com.globant.request.RequestBuilder;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ListAvailablePetsTests extends TestRunner {
    @Test(testName = "List available pets")
    public void listAvailablePets() {
        Response response = RequestBuilder.listAvailablePetsRequest(getBaseUrl(), "/pet/findByStatus?status=available", getApiKey());

        assertEquals(response.getStatusCode(), 200);
        assertEquals(response.getContentType(), "application/json", "The content type should be application/json.");
    }
}
