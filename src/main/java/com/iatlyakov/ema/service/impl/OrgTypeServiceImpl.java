package com.iatlyakov.ema.service.impl;

import com.iatlyakov.ema.entity.OrgType;
import com.iatlyakov.ema.repository.IOrgTypeRepository;
import com.iatlyakov.ema.service.IOrgTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrgTypeServiceImpl implements IOrgTypeService {

    @Autowired
    IOrgTypeRepository orgTypeRepository;

    @Override
    public void save(OrgType org) {
        orgTypeRepository.save(org);
    }

    @Override
    public List<OrgType> findAll() {
        return orgTypeRepository.findAll();
    }

    @Override
    public OrgType getTypeByName(String nameOrgType) {
        return orgTypeRepository.getByNameOrgType(nameOrgType);
    }

    @Override
    public void deleteType(Long orgId) {
        orgTypeRepository.deleteById(orgId);
    }


}
