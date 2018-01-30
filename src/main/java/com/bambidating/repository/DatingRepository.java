package com.bambidating.repository;

import com.bambidating.entity.DatingUser;
import com.bambidating.repository.Exeptions.LowBalanceException;

import java.util.List;

public interface DatingRepository {
    List<DatingUser> getDatingUsers(Long id);
    void selectDatingUser(Long userId, Long winnerUserId, Long loserUserId) throws LowBalanceException;
}
