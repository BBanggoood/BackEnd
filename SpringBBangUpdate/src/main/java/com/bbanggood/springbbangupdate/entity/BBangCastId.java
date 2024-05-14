package com.bbanggood.springbbangupdate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@Embeddable
public class BBangCastId implements java.io.Serializable {
    private static final long serialVersionUID = -5550428873683906608L;
    @Column(name = "SETBX_ID", nullable = false)
    private Integer setbxId;

    @Column(name = "VOD_CAST", nullable = false)
    private String vodCast;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BBangCastId entity = (BBangCastId) o;
        return Objects.equals(this.vodCast, entity.vodCast) &&
                Objects.equals(this.setbxId, entity.setbxId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vodCast, setbxId);
    }

}