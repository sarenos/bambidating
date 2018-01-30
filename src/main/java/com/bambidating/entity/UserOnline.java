package com.bambidating.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table( name = "bd_users" )

@Getter
@Setter
public class UserOnline {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", nullable = false)
    private Long id;

    @Column(name="last_action_date_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastActionDateTime;
}
