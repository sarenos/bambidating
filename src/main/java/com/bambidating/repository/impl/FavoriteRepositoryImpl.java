package com.bambidating.repository.impl;

import com.bambidating.entity.Favorite;
import com.bambidating.entity.FavoriteUser;
import com.bambidating.entity.UserProfile;
import com.bambidating.repository.FavoriteRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class FavoriteRepositoryImpl implements FavoriteRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void addToFavorite(Long userId, Long favoriteUserId) {
        Favorite favorite = new Favorite();
        favorite.setUserId(userId);
        favorite.setFavoriteUserId(favoriteUserId);
        favorite.setHash(DigestUtils.md5Hex(userId.toString()+favoriteUserId.toString()));
        entityManager.persist(favorite);
    }

    public List<FavoriteUser> getFavorites(Long userId) {
        String query = "SELECT fu FROM Favorite f, FavoriteUser fu where f.userId = "+userId+" and f.favoriteUserId = fu.id";
        Query q = entityManager.createQuery(query);
        return q.getResultList();
    }

    public void deleteFromFavorite(Long userId, Long favoriteUserId) {
        String query = "DELETE Favorite where userId = " + userId + " and f.favoriteUserId = "+ favoriteUserId;
        Query q = entityManager.createQuery(query);
        q.executeUpdate();
    }
}
