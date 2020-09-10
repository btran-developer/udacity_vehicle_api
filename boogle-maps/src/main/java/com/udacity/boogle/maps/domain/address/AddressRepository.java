package com.udacity.boogle.maps.domain.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query("FROM Address WHERE lat = :lat AND lon = :lon")
    Address findAddressByLatAndLon(@Param("lat") Double lat, @Param("lon") Double lon);
}
