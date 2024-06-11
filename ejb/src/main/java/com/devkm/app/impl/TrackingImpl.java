package com.devkm.app.impl;


import com.devkm.app.entity.CargoEntity;
import com.devkm.app.exception.CargoNotFoundException;
import com.devkm.app.remote.Tracking;
import jakarta.annotation.Resource;
import jakarta.ejb.*;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.SystemException;
import jakarta.transaction.UserTransaction;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class TrackingImpl implements Tracking {
    @PersistenceContext
    private EntityManager entityManager;
    @Inject
    private UserTransaction userTransaction;

    @Resource
    SessionContext sessionContext;
    Timer timer;


    @Override
    public String cargoTracking(Long id) {


        try {
            CargoEntity cargoEntity = entityManager.createNamedQuery("Cargo.findById", CargoEntity.class).setParameter(1, id).getSingleResult();
            if (cargoEntity != null) {
                String currentLocation = cargoEntity.getCurrentLocation();
                String status = cargoEntity.getStatus();
                String destinationLocation = cargoEntity.getDestinationLocation();
                String originLocation = cargoEntity.getOriginLocation();
                try {
                    userTransaction.begin();
                    CargoEntity merge = entityManager.merge(cargoEntity);
                    System.out.println(merge.getId());
                    userTransaction.commit();

                } catch (Exception e) {
                    try {
                        userTransaction.rollback();
                    } catch (SystemException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                return "cargoTrackingId : " + cargoEntity.getId()+ "currentLocation : " + currentLocation+" "+"destinationLocation : "+destinationLocation+" "+" originLocation : "+originLocation+" "+"cargo details"+ cargoEntity.getDetails()+" "+"cargo status : "+ cargoEntity.getStatus();
            } else {
                throw new CargoNotFoundException("Cargo Not Found");
            }
        } catch (NoResultException e) {
            throw new CargoNotFoundException("Cargo Not Found");
        }

    }


}
