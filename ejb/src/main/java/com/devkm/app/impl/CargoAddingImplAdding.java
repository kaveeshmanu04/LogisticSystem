package com.devkm.app.impl;


import com.devkm.app.entity.CargoEntity;
import com.devkm.app.interpritors.RouteInterceptor;
import com.devkm.app.interpritors.TrafficInterceptor;
import com.devkm.app.interpritors.WeatherInterceptor;
import com.devkm.app.remote.CargoAdding;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import jakarta.interceptor.Interceptors;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
@Stateless
public class CargoAddingImplAdding implements CargoAdding {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Interceptors({RouteInterceptor.class, TrafficInterceptor.class, WeatherInterceptor.class})
    public Long addCargo(String current_location, String origin_location, String destination, String status, String details) {
        CargoEntity cargoEntity = new CargoEntity(origin_location, destination, current_location, status, details);
        entityManager.persist(cargoEntity);
        entityManager.flush();
        Long  cargoId = cargoEntity.getId();
        System.out.println("Cargo created with ID: " + cargoId);
        return cargoId;


    }



}
