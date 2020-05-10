package com.BlogBoot.model;

import com.BlogBoot.model.enums.ModeratorStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Column(name = "is_active", nullable = false)
    private Byte isActive;

    @Enumerated(EnumType.STRING)
    @Column(name = "moderator_status", nullable = false, columnDefinition = "enum('NEW', 'ACCEPTED', 'DECLINED')")
    private ModeratorStatus moderatorStatus;

    @Column(name = "moderator_id")
    private Integer moderatorId;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(nullable = false)
    private Date time;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String text;

    @Column(name = "view_count", nullable = false)
    private Integer viewCount;


}
