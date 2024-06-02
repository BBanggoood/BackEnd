package com.bbanggood.springbbangupdate.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "bbang_cast")
public class BBangCast {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BBANG_CAST_ID", nullable = false)
    private Integer id;

    @Column(name = "SETBX_ID")
    private Integer setbxId;

    @Column(name = "VOD_CAST", length = 512)
    private String vodCast;

    @Column(name = "VOD_CAST_POSTER", length = 1024)
    private String vodCastPoster;

}