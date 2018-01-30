package com.bambidating.repository.impl;

import com.bambidating.entity.DatingUser;
import com.bambidating.entity.PhotoBattle;
import com.bambidating.repository.DatingRepository;
import com.bambidating.repository.Exeptions.LowBalanceException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class DatingRepositoryImpl implements DatingRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<DatingUser> getDatingUsers(Long id) {
        String query = "SELECT du FROM DatingUser du, Filter f where du.id != "+id+" and du.views >= 1 and f.userId = "+id+" and du.age BETWEEN f.minAge AND f.maxAge " +
                " ORDER BY RAND()";
        Query q = entityManager.createQuery(query);
        q.setMaxResults(2);
        List<DatingUser> datingUserList = q.getResultList();
        updateUsersViews(datingUserList);
        return datingUserList;
    }

    @Transactional
    public void selectDatingUser(Long userId, Long winnerUserId, Long loserUserId) throws LowBalanceException {

        PhotoBattle photoBattle = new PhotoBattle();
        photoBattle.setUserId(userId);
        photoBattle.setWinnerUserId(winnerUserId);
        photoBattle.setLoserUserId(loserUserId);
        entityManager.persist(photoBattle);

        String updateUserQuery = "UPDATE DatingUser SET views=views+1 WHERE id=?2";
        entityManager.createQuery(updateUserQuery).setParameter(2, userId).executeUpdate();

        String updateWinnerUserQuery = "UPDATE DatingUser SET balance=balance+1, winn=winn+1, views=views-1 WHERE id=?2";
        entityManager.createQuery(updateWinnerUserQuery).setParameter(2, winnerUserId).executeUpdate();

        String updateLoserUserQuery = "UPDATE DatingUser SET views=views-1, lose=lose+1 WHERE id=?2";
        entityManager.createQuery(updateLoserUserQuery).setParameter(2, loserUserId).executeUpdate();
    }

    private void updateUsersViews(List<DatingUser> datingUserList){
        for (DatingUser datingUser : datingUserList) {
            String updateUserQuery = "UPDATE DatingUser SET views=views-1 WHERE id=?1";
            entityManager.createQuery(updateUserQuery).setParameter(1, datingUser.getId()).executeUpdate();
        }
    }
}
