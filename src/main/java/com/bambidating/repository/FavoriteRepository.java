package com.bambidating.repository;

import com.bambidating.entity.FavoriteUser;

import java.util.List;

public interface FavoriteRepository {
    void addToFavorite(Long userId ,Long favoriteUserId);
    List<FavoriteUser> getFavorites(Long userId);
    void deleteFromFavorite(Long userId, Long favoriteUserId);
}
