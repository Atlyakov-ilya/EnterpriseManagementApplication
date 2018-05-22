package com.iatlyakov.ema.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_org_type")
public class OrgType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="F_ORG_TYPE_ID")
    private Long orgTypeId;
    @Column(name = "F_NAME_ORG_TYPE", nullable = false)
    @NotNull
    private String nameOrgType;

    public Long getOrgTypeId() {
        return orgTypeId;
    }

    public void setOrgTypeId(Long orgTypeId) {
        this.orgTypeId = orgTypeId;
    }

    public String getNameOrgType() {
        return nameOrgType;
    }

    public void setNameOrgType(String nameOrgType) {
        this.nameOrgType = nameOrgType;
    }

    public OrgType(String nameOrgType) {
        this.nameOrgType = nameOrgType;
    }

    public OrgType(){}


}
