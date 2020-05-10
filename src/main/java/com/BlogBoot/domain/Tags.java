package com.BlogBoot.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Tags {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String name;

}
