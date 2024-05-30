package com.bbanggood.springbbangupdate.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "bbang_vod")
public class BBangVod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BBANG_VOD_ID", nullable = false)
    private Integer id;

    @Column(name = "SETBX_ID")
    private Integer setbxId;

    @Column(name = "VOD_ID")
    private Integer vodId;

    @Column(name = "VOD_POSTER")
    private String vodPoster;

}