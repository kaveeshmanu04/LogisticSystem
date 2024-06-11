package com.devkm.app.impl;

import com.devkm.app.entity.CargoEntity;
import com.devkm.app.remote.CargoViewing;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.List;
@Stateless
public class CargoViewingImplViewing implements CargoViewing {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<CargoEntity> getCargo() {
        List<CargoEntity> cargoEntities =new ArrayList<>();
        cargoEntities = entityManager.createQuery("select c from CargoEntity c").getResultList();
        return cargoEntities;
    }
}
