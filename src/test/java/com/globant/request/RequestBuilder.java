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
    public static Response postRequest(String baseUrl, String path, String apiKey, Object body) {
        RequestSpecification requestSpecification = RestAssured.given()
                .baseUri(baseUrl)
                .header(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType())
                .header(APIKEY, apiKey)
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .body(body);

        return requestSpecification.post(path);
    }
    public static Response deleteRequest(String baseUrl, String path, String apiKey, String username) {
        RequestSpecification requestSpecification = RestAssured.given()
                .baseUri(baseUrl)
                .basePath(path)
                .pathParam("username", username)
                .header(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType())
                .header(APIKEY, apiKey)
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter());

        return requestSpecification.delete("/{username}");
    }
    public static Response loginRequest(String baseUrl, String path, String apiKey) {
        RequestSpecification requestSpecification = RestAssured.given()
                .baseUri(baseUrl)
                .basePath(path)
                .queryParam("username")
                .queryParam("password")
                .header(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType())
                .header(APIKEY, apiKey)
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter());

        return requestSpecification.get("/{username}/{password}");
    }
    public static Response logoutRequest(String baseUrl, String path, String apiKey) {
        RequestSpecification requestSpecification = RestAssured.given()
                .baseUri(baseUrl)
                .basePath(path)
                .header(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType())
                .header(APIKEY, apiKey)
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter());

        return requestSpecification.post();
    }
    public static Response listAvailablePetsRequest(String baseUrl, String path, String apiKey) {
        RequestSpecification requestSpecification = RestAssured.given()
                .baseUri(baseUrl)
                .basePath(path)
                .queryParam("status", "available")
                .header(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType())
                .header(APIKEY, apiKey)
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter());

        return requestSpecification.get();
    }
    public static Response createOrderRequest(String baseUrl, String path, String apiKey) {
        RequestSpecification requestSpecification = RestAssured.given()
                .baseUri(baseUrl)
                .basePath(path)
                .header(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType())
                .header(APIKEY, apiKey)
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter());

        return requestSpecification.post();
    }
    public static Response getPetDetailsRequest(String baseUrl, String path, String apiKey) {
        RequestSpecification requestSpecification = RestAssured.given()
                .baseUri(baseUrl)
                .basePath(path)
                .header(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType())
                .header(APIKEY, apiKey)
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter());

        return requestSpecification.get();
    }
}
