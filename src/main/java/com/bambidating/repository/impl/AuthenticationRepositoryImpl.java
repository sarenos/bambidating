package com.bambidating.repository.impl;

import com.bambidating.controller.Utils.Gender;
import com.bambidating.entity.*;
import com.bambidating.model.requestModel.RegistrationModel;
import com.bambidating.model.requestModel.VkAuthenticationModel;
import com.bambidating.repository.AuthenticationRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class AuthenticationRepositoryImpl implements AuthenticationRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Authentication login(String email){
        return entityManager.createQuery(
                "SELECT a from Authentication a WHERE a.email = :email", Authentication.class).
                setParameter("email", email).getSingleResult();
    }

    public Authentication findByEmail(String email){
        return entityManager.createQuery(
                "SELECT a from Authentication a WHERE a.email = :email", Authentication.class).
                setParameter("email", email).getSingleResult();
    }

    @Transactional
    public Long registration(RegistrationModel registrationModel) {
        Registration registration = new Registration();
        registration.setEmail(registrationModel.getEmail());
        registration.setPassword(DigestUtils.md5Hex(registrationModel.getPassword()));
        registration.setName(registrationModel.getName());
        registration.setGender(registrationModel.getGender());
        registration.setAge(registrationModel.getAge());
        entityManager.persist(registration);

        createDefaultFilter(registration.getId(),registrationModel.getGender());
        return registration.getId();
    }

    @Transactional
    public void online(Long userId) {
        String updateUserQuery = "UPDATE UserOnline SET lastActionDateTime = NOW() WHERE id=?1";
        entityManager.createQuery(updateUserQuery).setParameter(1, userId).executeUpdate();
    }


    private void createDefaultFilter(Long userId, Gender gender)
    {
        CreateDefaultFilter filter = new CreateDefaultFilter();
        filter.setUserId(userId);
        filter.setGender(gender.equals(Gender.FEMALE)? Gender.MALE : Gender.FEMALE);
        entityManager.persist(filter);
    }
}
