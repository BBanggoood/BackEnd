package com.bbanggood.springbbangupdate.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "like_cast")
public class BBangCast {
    @EmbeddedId
    private BBangCastId bbangCastId;

    @MapsId("setbxId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SETBX_ID", nullable = false)
    private UserMysql userMysql;

}