package com.bambidating.entity;

import com.bambidating.controller.Utils.Gender;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table( name = "bd_filter" )
@Getter
@Setter
public class Filter {

    @Id
    @Column(name="user_id", nullable = false)
    private Long userId;

    @Column(name="gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name="min_age")
    private Integer minAge;

    @Column(name="max_age")
    private Integer maxAge;

    @Column(name="online")
    private Integer online;

    @Column(name="photo")
    private Integer photo;
}
