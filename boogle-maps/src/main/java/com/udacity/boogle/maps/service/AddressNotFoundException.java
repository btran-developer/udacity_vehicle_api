package com.udacity.boogle.maps.service;

public class AddressNotFoundException extends RuntimeException {
    public AddressNotFoundException() { }

    public AddressNotFoundException(String message) {
        super(message);
    }
}
