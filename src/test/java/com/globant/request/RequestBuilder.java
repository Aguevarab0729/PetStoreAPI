package com.globant.request;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpHeaders;
import org.apache.http.entity.ContentType;

public class RequestBuilder {
    private static final String APIKEY = "x-api-key";
    public static Response getRequest(String baseUrl, String path, String apiKey) {
        //Todas las configuraciones necesarias para realizar una petición
        RequestSpecification requestSpecification = RestAssured.given()
                .baseUri(baseUrl)
                .header(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType())
                .header(APIKEY, apiKey)
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter());

        return requestSpecification.get(path);
    }
}
