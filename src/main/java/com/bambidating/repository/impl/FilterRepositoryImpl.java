package com.bambidating.repository.impl;

import com.bambidating.entity.Filter;
import com.bambidating.model.requestModel.FilterModel;
import com.bambidating.repository.FilterRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class FilterRepositoryImpl implements FilterRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public Filter getFilter(Long userId) {
        return entityManager.find(Filter.class, userId);
    }

    @Transactional
    public void updateFilter(Long userId, FilterModel userProfileModel) {
        Filter filter = new Filter();
        filter.setUserId(userId);
        filter.setMinAge(userProfileModel.getMinAge());
        filter.setMaxAge(userProfileModel.getMaxAge());
        filter.setGender(userProfileModel.getGender());
        filter.setOnline(userProfileModel.getOnline());
        filter.setPhoto(userProfileModel.getWithPhoto());
        entityManager.merge(filter);
    }
}
