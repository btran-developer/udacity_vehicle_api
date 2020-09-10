package com.udacity.boogle.maps.api;

import com.udacity.boogle.maps.domain.address.Address;
//import com.udacity.boogle.maps.domain.address.MockAddressRepository;
import com.udacity.boogle.maps.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/maps")
public class MapsController {

    @Autowired
    AddressService addressService;

    @GetMapping
    public Address get(@RequestParam Double lat, @RequestParam Double lon) {

//        return MockAddressRepository.getRandom();
        Address address = addressService.getAddress(lat, lon);

        return address;
    }

    @PostMapping
    public Address put(@RequestParam Double lat, @RequestParam Double lon, @RequestBody Address address) {
        Address updateAddress = addressService.save(lat, lon, address.getLat(), address.getLon());

        return updateAddress;
    }
}
