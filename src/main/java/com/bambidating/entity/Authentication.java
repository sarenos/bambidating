package com.bambidating.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table( name = "bd_users" )
@Getter
@Setter
public class Authentication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", nullable = false)
    private Long id;

    @Column(name="email")
    private String email;

    @Column(name="password", nullable = false)
    private String password;
}
