package com.devkm.app.impl;


import com.devkm.app.entity.CargoEntity;
import com.devkm.app.remote.CargoUpdating;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
@Stateless
public class CargoUpdatingImplUpdating implements CargoUpdating {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public CargoEntity viewSelectedCargoDetails(Long id) {
        CargoEntity cargoEntity = entityManager.createNamedQuery("Cargo.findById", CargoEntity.class).setParameter(1, id).getSingleResult();
        return cargoEntity;
    }

    @Override
    public CargoEntity updateCargo(Long id, String currentLocation, String originLocation, String destinationLocation, String status, String details) {
        CargoEntity cargoEntity = entityManager.createNamedQuery("Cargo.findById", CargoEntity.class).setParameter(1, id).getSingleResult();
        cargoEntity.setCurrentLocation(currentLocation);
        cargoEntity.setOriginLocation(originLocation);
        cargoEntity.setDestinationLocation(destinationLocation);
        cargoEntity.setStatus(status);
        cargoEntity.setDetails(details);
        entityManager.persist(cargoEntity);
        return cargoEntity;
    }

}
