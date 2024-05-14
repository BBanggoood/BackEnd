package com.bbanggood.springbbangupdate.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "like_director")
public class BBangDirector {
    @EmbeddedId
    private BBangDirectorId id;

}