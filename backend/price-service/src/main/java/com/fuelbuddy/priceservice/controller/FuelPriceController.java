package com.fuelbuddy.priceservice.controller;

import com.fuelbuddy.priceservice.dto.PriceRequest;
import com.fuelbuddy.priceservice.entity.FuelPrice;
import com.fuelbuddy.priceservice.entity.FuelType;
import com.fuelbuddy.priceservice.service.FuelPriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/prices")
@RequiredArgsConstructor
public class FuelPriceController {

    private final FuelPriceService fuelPriceService;

    @PostMapping
    public ResponseEntity<?> addOrUpdatePrice(@RequestBody PriceRequest request) {
        try {
            FuelPrice fuelPrice = fuelPriceService.addOrUpdatePrice(request);

            Map<String, Object> response = new HashMap<>();
            response.put("message", "Price saved successfully");
            response.put("id", fuelPrice.getId());
            response.put("stationId", fuelPrice.getStationId());
            response.put("fuelType", fuelPrice.getFuelType());
            response.put("price", fuelPrice.getPrice());
            response.put("updatedAt", fuelPrice.getUpdatedAt());

            return ResponseEntity.ok(response);

        } catch (RuntimeException e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @GetMapping
    public ResponseEntity<List<FuelPrice>> getAllPrices() {
        return ResponseEntity.ok(fuelPriceService.getAllPrices());
    }

    @GetMapping("/station/{stationId}")
    public ResponseEntity<List<FuelPrice>> getPricesByStation(@PathVariable Long stationId) {
        return ResponseEntity.ok(fuelPriceService.getPricesByStation(stationId));
    }

    @GetMapping("/cheapest")
    public ResponseEntity<?> getCheapestByFuelType(@RequestParam FuelType fuelType) {
        try {
            List<FuelPrice> prices = fuelPriceService.getCheapestByFuelType(fuelType);
            return ResponseEntity.ok(prices);

        } catch (RuntimeException e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }
}
