package com.globant.model.users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CreateOrderDTO {
    public int id = 12345;
    public int petId = 67890;
    public int quantity = 1;
    public String shipDate = "2025-07-01T18:22:43.603Z";
    public String status = "placed";
    public boolean complete = true;
}
