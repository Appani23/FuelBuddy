package com.fuelbuddy.stationservice.service;

import com.fuelbuddy.stationservice.dto.StationRequest;
import com.fuelbuddy.stationservice.entity.Station;
import com.fuelbuddy.stationservice.repository.StationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StationService {

    private final StationRepository stationRepository;

    public Station createStation(StationRequest request) {
        Station station = new Station();
        station.setName(request.getName());
        station.setAddress(request.getAddress());
        station.setCity(request.getCity());
        station.setState(request.getState());
        station.setZipCode(request.getZipCode());
        station.setLatitude(request.getLatitude());
        station.setLongitude(request.getLongitude());
        station.setBrand(request.getBrand());

        return stationRepository.save(station);
    }

    public List<Station> getAllStations() {
        return stationRepository.findAll();
    }

    public Station getStationById(Long id) {
        return stationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Station not found with id: " + id));
    }

    public List<Station> findNearbyStations(double lat, double lng, double radiusInMiles) {
        double radiusInKm = radiusInMiles * 1.609;
        List<Station> allStations = stationRepository.findAll();

        return allStations.stream()
                .filter(station -> haversineDistance(lat, lng, station.getLatitude(), station.getLongitude()) <= radiusInKm)
                .collect(Collectors.toList());
    }

    private double haversineDistance(double lat1, double lng1, double lat2, double lng2) {
        final double EARTH_RADIUS_KM = 6371.0;

        double dLat = Math.toRadians(lat2 - lat1);
        double dLng = Math.toRadians(lng2 - lng1);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLng / 2) * Math.sin(dLng / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS_KM * c;
    }
}
