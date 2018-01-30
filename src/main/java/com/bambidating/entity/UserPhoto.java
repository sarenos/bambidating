package com.bambidating.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table( name = "bd_user_photo" )

@Getter
@Setter
public class UserPhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", nullable = false)
    private Long id;

    @Column(name="user_id", nullable = false)
    private Long userId;

    @Column(name="key_code")
    private String keyCode;

    @Column(name="photo_full_size")
    private String photoFullSize;
}
