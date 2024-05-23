package com.bbanggood.springbbangupdate.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "like_cast")
public class BBangCast {
    @EmbeddedId
    private BBangCastId bbangCastId;

    @ManyToOne
    @JoinColumn(name = "setbx_id", insertable = false, updatable = false, referencedColumnName = "setbx_id")
    private UserMysql userMysql;

    @ManyToOne
    @JoinColumn(name = "vod_cast", insertable = false, updatable = false, referencedColumnName = "vod_cast")
    private Vod vod;
}