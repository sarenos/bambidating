package com.bambidating.repository;

import com.bambidating.entity.Filter;
import com.bambidating.entity.UserProfile;
import com.bambidating.model.requestModel.FilterModel;

public interface FilterRepository {
    Filter getFilter(Long userId);
    void updateFilter(Long userId, FilterModel userProfileModel);
}
