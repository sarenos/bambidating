package com.bambidating.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table( name = "bd_messages" )
@Getter
@Setter
public class SendMessage {

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
}
