package com.bambidating.repository.impl;

import com.bambidating.entity.UpdateUserProfileInfo;
import com.bambidating.entity.UserPhoto;
import com.bambidating.entity.UserProfile;
import com.bambidating.model.requestModel.UploadPhotoModel;
import com.bambidating.repository.UserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public UserProfile getUserProfileInfoById(Long id) {
        return entityManager.find(UserProfile.class, id);
    }

    @Transactional
    public void updateUserProfileInfo(UpdateUserProfileInfo userProfile) {
        entityManager.merge(userProfile);
    }

    public void deleteUserProfile(Long userId) {
        UserProfile userProfile = new UserProfile();
        userProfile.setId(userId);
        entityManager.remove(userProfile);
    }

    @Transactional
    public void uploadPhoto(Long userId, UploadPhotoModel uploadPhotoModel) {
        UserPhoto userPhoto = new UserPhoto();
        userPhoto.setUserId(userId);
        userPhoto.setKeyCode(uploadPhotoModel.getKey());
        userPhoto.setPhotoFullSize(uploadPhotoModel.getFull_size());
        entityManager.persist(userPhoto);
    }
}
