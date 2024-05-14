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
public class BBangDirectorId implements java.io.Serializable {
    private static final long serialVersionUID = -6405641302002483348L;
    @Column(name = "SETBX_ID", nullable = false)
    private Integer setbxId;

    @Column(name = "VOD_DIRECTOR", nullable = false)
    private String vodDirector;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BBangDirectorId entity = (BBangDirectorId) o;
        return Objects.equals(this.setbxId, entity.setbxId) &&
                Objects.equals(this.vodDirector, entity.vodDirector);
    }

    @Override
    public int hashCode() {
        return Objects.hash(setbxId, vodDirector);
    }

}