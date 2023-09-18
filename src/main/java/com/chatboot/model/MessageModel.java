package com.chatboot.model;

import com.chatboot.controller.request.MESSAGETYPE;
import jakarta.persistence.*;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.security.Timestamp;

@Entity
public class MessageModel {
    @Id
    @Column(name = "message_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "message_content")
    private String content;
    @Column(name = "message_sender")
    private String sender;
    @Enumerated(EnumType.STRING)
    @Column(name = "message_messageType")
    private MESSAGETYPE messagetype;
    @CreationTimestamp
    private Timestamp sendedAt;
}
