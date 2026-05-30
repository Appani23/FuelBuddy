package com.fuelbuddy.priceservice.service;

import com.fuelbuddy.priceservice.dto.PriceRequest;
import com.fuelbuddy.priceservice.entity.FuelPrice;
import com.fuelbuddy.priceservice.entity.FuelType;
import com.fuelbuddy.priceservice.repository.FuelPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FuelPriceService {

    private final FuelPriceRepository fuelPriceRepository;

    public FuelPrice addOrUpdatePrice(PriceRequest request) {
        Optional<FuelPrice> existing = fuelPriceRepository
                .findByStationIdAndFuelType(request.getStationId(), request.getFuelType());

        FuelPrice fuelPrice = existing.orElse(new FuelPrice());
        fuelPrice.setStationId(request.getStationId());
        fuelPrice.setFuelType(request.getFuelType());
        fuelPrice.setPrice(request.getPrice());

        return fuelPriceRepository.save(fuelPrice);
    }

    public List<FuelPrice> getPricesByStation(Long stationId) {
        return fuelPriceRepository.findByStationId(stationId);
    }

    public List<FuelPrice> getAllPrices() {
        return fuelPriceRepository.findAll();
    }

    public List<FuelPrice> getCheapestByFuelType(FuelType fuelType) {
        return fuelPriceRepository.findAll().stream()
                .filter(fp -> fp.getFuelType() == fuelType)
                .sorted(Comparator.comparingDouble(FuelPrice::getPrice))
                .collect(Collectors.toList());
    }
}
