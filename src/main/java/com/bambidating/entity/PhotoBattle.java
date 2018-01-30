package com.bambidating.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table( name = "bd_photo_battle" )

@Getter
@Setter
public class PhotoBattle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", nullable = false)
    private Long id;

    @Column(name="user_id", nullable = false)
    private Long userId;

    @Column(name="winner_user_id", nullable = false)
    private Long winnerUserId;

    @Column(name="loser_user_id", nullable = false)
    private Long loserUserId;
}
