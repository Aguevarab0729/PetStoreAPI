package com.globant.test;

import com.globant.config.TestRunner;
import com.globant.model.users.LoginDTO;
import com.globant.request.RequestBuilder;
import com.globant.model.users.GetUserLoginResponseDTO;
import org.testng.annotations.Test;
import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;
public class LoginUserTest extends TestRunner {

    @Test(testName = "Validate user login")
    public void validateUserLogin() {
        Response response = RequestBuilder.loginRequest( getBaseUrl(), "/user/login", getApiKey());
        GetUserLoginResponseDTO getUserLoginResponseDTO = response.as(GetUserLoginResponseDTO.class);

        assertEquals(response.getStatusCode(), 200);
        assertEquals(getUserLoginResponseDTO.getLoginDTO().getUsername(), "prueba1", "The username matches the expected value.");
        assertEquals(getUserLoginResponseDTO.getLoginDTO().getPassword(), "123456", "The password matches the expected value.");

        /*LoginDTO loginDTO = LoginDTO.builder()
                .username("prueba1")
                .password("123456")
                .build();
        Response response = RequestBuilder.getRequest(getBaseUrl(), "/user/login", getApiKey()), LoginDTO);
        GetUserLoginResponseDTO getUserLoginResponseDTO = response.as(GetUserLoginResponseDTO.class);

        assertEquals(response.getStatusCode(), 200,"The user login was successful.");*/
    }
}
