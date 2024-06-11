package com.devkm.app.exception;

public class CargoNotFoundException extends RuntimeException{
    public CargoNotFoundException(String message) {
        super(message);
    }
}
