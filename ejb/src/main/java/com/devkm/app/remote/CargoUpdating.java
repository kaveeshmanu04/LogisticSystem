package com.devkm.app.remote;

import com.devkm.app.entity.CargoEntity;
import jakarta.ejb.Remote;

@Remote
public interface CargoUpdating {
    public CargoEntity viewSelectedCargoDetails(Long id);
    public CargoEntity updateCargo(Long id,String currentLocation,String originLocation,String destinationLocation, String status,String details);
}
