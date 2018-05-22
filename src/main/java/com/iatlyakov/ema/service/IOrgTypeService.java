package com.iatlyakov.ema.service;

import com.iatlyakov.ema.entity.OrgType;

import java.util.List;

public interface IOrgTypeService {

    void save(OrgType org);

    List<OrgType> findAll();

    OrgType getTypeByName(String nameOrgType);

    void deleteType(Long orgId);

}
