package com.bbanggood.springbbangupdate.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "like_vod")
public class BBangVod {
    @EmbeddedId
    private BBangVodId bbangVodId;

    @ManyToOne
    @JoinColumn(name = "setbx_id", insertable = false, updatable = false, referencedColumnName = "setbx_id")
    private UserMysql userMysql;

    @ManyToOne
    @JoinColumn(name = "vod_id", insertable = false, updatable = false, referencedColumnName = "vod_id")
    private Vod vod;
}