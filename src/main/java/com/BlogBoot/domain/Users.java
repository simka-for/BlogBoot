package com.BlogBoot.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "usr")
public class Users {
<<<<<<< Updated upstream:src/main/java/com/BlogBoot/domain/Users.java
=======

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column(name = "is_moderator", nullable = false)
    private Byte isModerator;

    @Column(name = "reg_time", nullable = false)
    private Date regTime;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private String code;

    private String photo;

>>>>>>> Stashed changes:src/main/java/com/BlogBoot/model/Users.java
}
