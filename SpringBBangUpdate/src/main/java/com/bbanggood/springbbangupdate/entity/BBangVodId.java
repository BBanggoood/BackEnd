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
public class BBangVodId implements java.io.Serializable {
    private static final long serialVersionUID = -6436117837187303368L;
    @Column(name = "SETBX_ID", nullable = false)
    private Integer setbxId;

    @Column(name = "VOD_ID", nullable = false)
    private Integer vodId;

    // equals, hashcode 오버라이드 이유: 복합 키가 동일한지 정확히 비교하기 위해
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BBangVodId entity = (BBangVodId) o;
        return Objects.equals(this.setbxId, entity.setbxId) &&
                Objects.equals(this.vodId, entity.vodId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(setbxId, vodId);
    }

}