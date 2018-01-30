package com.bambidating.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table( name = "bd_messages" )
@Getter
@Setter
public class MessageHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", nullable = false)
    private Long id;

    @Column(name="from_user_id", nullable = false)
    private Long fromUserId;

    @Column(name="to_user_id", nullable = false)
    private Long toUserId;

    @Column(name="text", nullable = false, columnDefinition="TEXT")
    private String messageText;

    @Column(name="date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
}
