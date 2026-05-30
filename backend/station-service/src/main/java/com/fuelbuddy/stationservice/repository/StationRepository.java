package com.fuelbuddy.stationservice.repository;

import com.fuelbuddy.stationservice.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StationRepository extends JpaRepository<Station, Long> {

    List<Station> findByCity(String city);

    List<Station> findByBrand(String brand);
}
