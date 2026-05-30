package com.fuelbuddy.stationservice.dto;

import lombok.Data;

@Data
public class StationRequest {
    private String name;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private Double latitude;
    private Double longitude;
    private String brand;
}
