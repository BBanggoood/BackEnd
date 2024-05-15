package com.bbanggood.springbbangupdate.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "like_vod")
public class BBangVod {
    @EmbeddedId
    private BBangVodId bbangVodId;

    @MapsId("setbxId")
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SETBX_ID", nullable = false)
    private UserMysql userMysql;

}