package com.bbanggood.springbbangupdate.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "like_vod")
public class BBangVod {
    @EmbeddedId
    private BBangVodId id;

}