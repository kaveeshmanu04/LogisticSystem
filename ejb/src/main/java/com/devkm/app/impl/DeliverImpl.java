package com.devkm.app.impl;


import com.devkm.app.entity.CargoEntity;
import com.devkm.app.exception.CargoNotFoundException;
import com.devkm.app.remote.Deliver;
import jakarta.annotation.Resource;
import jakarta.ejb.*;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.SystemException;
import jakarta.transaction.UserTransaction;

import java.util.Random;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class DeliverImpl implements Deliver {
    @PersistenceContext
    private EntityManager entityManager;
    @Inject
    private UserTransaction userTransaction;
    @Resource
    private SessionContext sessionContext;
    Timer timer;
    Long cargoId = 1L;

    @Override
    public void time(Long id) {
        ScheduleExpression scheduleExpression = new ScheduleExpression();
        scheduleExpression.hour("*");
        scheduleExpression.minute("*");
        scheduleExpression.second("*");
        timer = sessionContext.getTimerService().createCalendarTimer(scheduleExpression);
        cargoId = id;
    }

    @Timeout
    @Override
    public void run() {

        try {
            CargoEntity cargoEntity = entityManager.createNamedQuery("Cargo.findById", CargoEntity.class).setParameter(1, cargoId).getSingleResult();
            if (cargoEntity != null) {
                String currentLocation = cargoEntity.getCurrentLocation();
                String status = cargoEntity.getStatus();
                String destinationLocation = cargoEntity.getDestinationLocation();
                String originLocation = cargoEntity.getOriginLocation();
                String[] cities = {
                        "Colombo",
                        "Galle",
                        "Kandy",
                        "Anuradhapura",
                        "Matara",
                        "Negombo",
                        "Kalutara",
                        "Ratnapura",
                        "Kurunegala",
                        "Badulla",
                        "Avissawella",
                        "Embilipitiya",
                        "Kataragama",
                        "Beliatta",
                        "Chilaw",
                        "Nuwara Eliya",
                        "Ampara",
                        "Hambantota",
                        "Tangalle",
                        "Weligama",
                        "Mirissa",
                        "Hikkaduwa",
                        "Unawatuna",
                        "Bentota",
                        "Sigiriya",
                        "Dambulla",
                        "Polonnaruwa",
                        "Ella",
                        "Haputale",
                        "Bandarawela",
                        "Monaragala",
                        "Kegalle",
                        "Matale",
                        "Gampaha",

                };
                Random random =new Random();
                int randomIndex = random.nextInt(cities.length);
                String randomCity = cities[randomIndex];
                cargoEntity.setCurrentLocation(randomCity);


                if (cargoEntity.getCurrentLocation().equals(destinationLocation)) {
                    timer.cancel();
                    cargoEntity.setStatus("Delivered");
                    System.out.println("stop");
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

                }
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
                System.out.println("currentLocation : " + currentLocation);
            } else {
                throw new CargoNotFoundException("Cargo Not Found");
            }
        } catch (NoResultException e) {
            throw new CargoNotFoundException("Cargo Not Found");
        }
    }
}
