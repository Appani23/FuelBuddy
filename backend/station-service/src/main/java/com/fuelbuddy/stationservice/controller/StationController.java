package com.fuelbuddy.stationservice.controller;

import com.fuelbuddy.stationservice.dto.StationRequest;
import com.fuelbuddy.stationservice.entity.Station;
import com.fuelbuddy.stationservice.service.StationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/stations")
@RequiredArgsConstructor
public class StationController {

    private final StationService stationService;

    @PostMapping
    public ResponseEntity<?> createStation(@RequestBody StationRequest request) {
        try {
            Station station = stationService.createStation(request);

            Map<String, Object> response = new HashMap<>();
            response.put("message", "Station created successfully");
            response.put("stationId", station.getId());
            response.put("name", station.getName());
            response.put("city", station.getCity());
            response.put("brand", station.getBrand());

            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        } catch (RuntimeException e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @GetMapping
    public ResponseEntity<List<Station>> getAllStations() {
        return ResponseEntity.ok(stationService.getAllStations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStationById(@PathVariable Long id) {
        try {
            Station station = stationService.getStationById(id);
            return ResponseEntity.ok(station);

        } catch (RuntimeException e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
    }

    @GetMapping("/nearby")
    public ResponseEntity<List<Station>> findNearbyStations(
            @RequestParam double lat,
            @RequestParam double lng,
            @RequestParam double radius) {

        List<Station> stations = stationService.findNearbyStations(lat, lng, radius);
        return ResponseEntity.ok(stations);
    }
}
