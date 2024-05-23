package com.bbanggood.springbbangupdate.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "vod")
public class Vod {
    @Id
    @Column(name = "VOD_ID", nullable = false)
    private Integer vodId;

    @Column(name = "VOD_NAME", nullable = false)
    private String vodName;

    @Column(name = "VOD_POSTER")
    private String vodPoster;

    @Lob
    @Column(name = "VOD_CLASSIFY", nullable = false)
    private String vodClassify;

    @Column(name = "VOD_GENRE")
    private String vodGenre;

    @Column(name = "VOD_KEYWORD")
    private String vodKeyword;

    @Lob
    @Column(name = "VOD_SUMMARY")
    private String vodSummary;

    @Column(name = "VOD_CAST")
    private String vodCast;

    @Column(name = "VOD_CAST_POSTER")
    private String vodCastPoster;

    @Column(name = "VOD_DIRECTOR")
    private String vodDirector;

    @Column(name = "VOD_DIRECTOR_POSTER")
    private String vodDirectorPoster;

    @Column(name = "VOD_OPEN_AT")
    private LocalDate vodOpenAt;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "VOD_UPDATED_AT")
    private Instant vodUpdatedAt;

    @Column(name = "VOD_PRICE")
    private Integer vodPrice;

    @Column(name = "VOD_TIME", length = 16)
    private String vodTime;

    @Column(name = "VOD_INITIAL", length = 50)
    private String vodInitial;

    @ColumnDefault("0")
    @Column(name = "VOD_COUNT")
    private Integer vodCount;

}