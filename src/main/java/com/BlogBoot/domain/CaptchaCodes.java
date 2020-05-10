package com.BlogBoot.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class CaptchaCodes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private Date time;

    @Column(nullable = false)
    private Byte code;

    @Column(name = "secret_code", nullable = false)
    private Byte secretCode;
}
