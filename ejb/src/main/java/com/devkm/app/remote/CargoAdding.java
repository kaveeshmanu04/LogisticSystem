package com.devkm.app.remote;

import jakarta.ejb.Remote;

@Remote
public interface CargoAdding {
    public Long addCargo(String current_location,String origin_location,String destination,String status,String details);

}
