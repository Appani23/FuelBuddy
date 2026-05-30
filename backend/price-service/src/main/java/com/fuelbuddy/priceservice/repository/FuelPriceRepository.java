package com.fuelbuddy.priceservice.repository;

import com.fuelbuddy.priceservice.entity.FuelPrice;
import com.fuelbuddy.priceservice.entity.FuelType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FuelPriceRepository extends JpaRepository<FuelPrice, Long> {

    List<FuelPrice> findByStationId(Long stationId);

    Optional<FuelPrice> findByStationIdAndFuelType(Long stationId, FuelType fuelType);
}
