package com.globant.test;

import com.globant.config.TestRunner;
import com.globant.model.users.CreateOrderDTO;
import com.globant.model.users.CreateOrderResponseDTO;
import com.globant.request.RequestBuilder;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CreateOrderTests extends TestRunner {

    @Test(testName = "Validate order creation")
    public void validateOrderCreation() {
        CreateOrderDTO createOrderDTO = CreateOrderDTO.builder()
                .id(1)
                .petId(123)
                .quantity(2)
                .shipDate("2023-10-01T10:00:00Z")
                .status("placed")
                .complete(true)
                .build();
        Response response = RequestBuilder.createOrderRequest(getBaseUrl(), "/store/order", getApiKey());
        CreateOrderResponseDTO createOrderResponseDTO = response.as(CreateOrderResponseDTO.class);

        assertEquals(response.getStatusCode(), 201);
        assertEquals(createOrderResponseDTO.getId(), 1, "The order ID matches the expected value.");
        assertEquals(createOrderResponseDTO.getPetId(), 123, "The pet ID matches the expected value.");
        assertEquals(createOrderResponseDTO.getQuantity(), 2, "The quantity matches the expected value.");
        assertEquals(createOrderResponseDTO.getShipDate(), "2023-10-01T10:00:00Z", "The ship date matches the expected value.");
        assertEquals(createOrderResponseDTO.getStatus(), "placed", "The status matches the expected value.");
    }
}
