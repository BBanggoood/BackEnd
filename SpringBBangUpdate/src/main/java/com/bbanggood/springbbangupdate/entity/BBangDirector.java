package com.bbanggood.springbbangupdate.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "bbang_director")
public class BBangDirector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BBANG_DIRECTOR_ID", nullable = false)
    private Integer id;

    @Column(name = "SETBX_ID")
    private Integer setbxId;

    @Column(name = "VOD_DIRECTOR", length = 512)
    private String vodDirector;

    @Column(name = "VOD_DIRECTOR_POSTER", length = 1024)
    private String vodDirectorPoster;

}