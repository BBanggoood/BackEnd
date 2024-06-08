package com.bbanggood.springviewrecord.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "click")
public class Click {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLICK_ID", nullable = false)
    private Integer id;

    @Column(name = "SETBX_ID", nullable = false)
    private Integer setbxId;

    @Column(name = "VOD_ID", nullable = false)
    private Integer vodId;

    @Lob
    @Column(name = "VIEW_TYPE", nullable = false)
    private String viewType;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "CLICK_TIME")
    private Instant clickTime;

}