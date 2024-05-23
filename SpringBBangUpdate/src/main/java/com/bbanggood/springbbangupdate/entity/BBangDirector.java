package com.bbanggood.springbbangupdate.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "like_director")
public class BBangDirector {
    @EmbeddedId
    private BBangDirectorId bbangDirectorId;

    @ManyToOne
    @JoinColumn(name = "setbx_id", insertable = false, updatable = false, referencedColumnName = "setbx_id")
    private UserMysql userMysql;

    @ManyToOne
    @JoinColumn(name = "vod_director", insertable = false, updatable = false, referencedColumnName = "vod_director")
    private Vod vod;
}