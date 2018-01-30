package com.bambidating.entity;

import com.bambidating.controller.Utils.Gender;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table( name = "bd_filter" )
@Getter
@Setter
public class CreateDefaultFilter {

    @Id
    @Column(name="user_id", nullable = false)
    private Long userId;

    @Column(name="gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
