package com.globant.test;

import com.globant.config.TestRunner;
import com.globant.request.RequestBuilder;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LogoutUserTests extends TestRunner {
    @Test(testName = "Validate user logout")
    public void validateUserLogout() {
        Response response = RequestBuilder.logoutRequest(getBaseUrl(), "/user/logout", getApiKey());
        assertEquals(response.getStatusCode(), 200, "The user was logged out successfully.");
    }
}
