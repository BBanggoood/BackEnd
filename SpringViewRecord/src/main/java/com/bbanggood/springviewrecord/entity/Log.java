package com.bbanggood.springviewrecord.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "log")
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOG_ID", nullable = false)
    private Integer id;

    @Column(name = "SETBX_ID", nullable = false)
    private Integer setbxId;

    @Column(name = "VOD_NAME", nullable = false)
    private String vodName;

    @Column(name = "WATCH_TIME")
    private Integer watchTime;

    @Column(name = "START_TIME")
    private Instant startTime;

    @Column(name = "END_TIME")
    private Instant endTime;

}