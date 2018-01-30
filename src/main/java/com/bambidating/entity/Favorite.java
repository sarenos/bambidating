package com.bambidating.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table( name = "bd_favorits" )

@Getter
@Setter
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", nullable = false)
    private Long id;

    @Column(name="user_id", nullable = false)
    private Long userId;

    @Column(name="favorite_user_id", nullable = false)
    private Long favoriteUserId;

    @Column(name="hash", nullable = false)
    private String hash;
}
