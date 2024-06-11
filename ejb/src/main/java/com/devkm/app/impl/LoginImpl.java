package com.devkm.app.impl;

import com.devkm.app.entity.UserEntity;
import com.devkm.app.remote.Login;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class LoginImpl implements Login {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public String login(String email, String password) {
        UserEntity userEntity = entityManager.createQuery("select u from UserEntity u where u.email=:email and u.password=:password", UserEntity.class)
                .setParameter("email", email)
                .setParameter("password", password)
                .getSingleResult();
        String userType;
        if (userEntity != null) {
          userType = userEntity.getUser_type();
        }else {
           userType="NONE";
        }
        System.out.println(userType);
        return userType;
    }
}
