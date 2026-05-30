package com.fuelbuddy.priceservice.dto;

import com.fuelbuddy.priceservice.entity.FuelType;
import lombok.Data;

@Data
public class PriceRequest {
    private Long stationId;
    private FuelType fuelType;
    private Double price;
}
