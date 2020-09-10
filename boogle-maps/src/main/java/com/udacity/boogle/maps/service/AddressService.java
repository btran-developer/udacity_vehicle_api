package com.udacity.boogle.maps.service;

import com.udacity.boogle.maps.domain.address.Address;
import com.udacity.boogle.maps.domain.address.AddressRepository;
import com.udacity.boogle.maps.domain.address.MockAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address getAddress(Double lat, Double lon) {
        Address address = addressRepository.findAddressByLatAndLon(lat, lon);

        if(address == null) {
            address = MockAddressRepository.getRandom();
            address.setLat(lat);
            address.setLon(lon);
            addressRepository.save(address);
        }

        return address;
    }

    public Address save(Double lat, Double lon, Double newLat, Double newLon) {
        Address address;

        if(lat != null && lon != null) {
            address = addressRepository.findAddressByLatAndLon(lat, lon);

            if(address != null) {
                address = MockAddressRepository.getRandom();
                address.setLat(newLat);
                address.setLon(newLon);
                addressRepository.save(address);
            } else {
                throw new AddressNotFoundException();
            }
        } else {
            address = MockAddressRepository.getRandom();
            address.setLat(newLat);
            address.setLon(newLon);
            addressRepository.save(address);
        }

        return address;
    }
}
