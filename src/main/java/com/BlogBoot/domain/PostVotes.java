package com.BlogBoot.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class PostVotes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "post_id", nullable = false)
    private Integer postId;

    @Column(nullable = false)
    private Date time;

    @Column(nullable = false)
    private Byte value;

}
