package com.bambidating.entity;


import com.bambidating.controller.Utils.Gender;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table( name = "bd_users" )
@Getter
@Setter
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", nullable = false)
    private Long id;

    @Column(name="email")
    private String email;

    @Column(name="password", nullable = false)
    private String password;

    @Column(name="name")
    private String name;

    @Column(name="gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name="age")
    private Integer age;
}
