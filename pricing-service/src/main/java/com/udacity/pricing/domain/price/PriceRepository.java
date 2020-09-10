package com.udacity.pricing.domain.price;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
    @Query("FROM Price WHERE vehicleId = :id")
    Price findPriceByVehicleId(Long id);
}
