package com.iatlyakov.ema.service.impl;

import com.iatlyakov.ema.entity.Organization;
import com.iatlyakov.ema.repository.IOrgTypeRepository;
import com.iatlyakov.ema.repository.IOrganizationRepository;
import com.iatlyakov.ema.service.IOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationServiceImpl implements IOrganizationService {

    @Autowired
    IOrganizationRepository organizationRepository;

    @Autowired
    IOrgTypeRepository orgTypeRepository;

    @Override
    public void save(Organization org) {
        organizationRepository.save(org);
    }

    @Override
    public List<Organization> findAll() {
        return organizationRepository.findAll();
    }

    @Override
    public Organization getOrganizationById(Long orgId) {
        return organizationRepository.findById(orgId).get();
    }

    @Override
    public void deleteOrganization(Long orgId) {
        organizationRepository.deleteById(orgId);
    }

    @Override
    public void updateOrganization(Organization org, Long orgId) {
         org.setOrgId(orgId);
         organizationRepository.save(org);
    }
}
