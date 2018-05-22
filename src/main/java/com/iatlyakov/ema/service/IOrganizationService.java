package com.iatlyakov.ema.service;

import com.iatlyakov.ema.entity.Organization;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IOrganizationService {

    void save(Organization org);

    List<Organization> findAll();

    Organization getOrganizationById(Long orgId);

    void deleteOrganization(Long orgId);

    void updateOrganization(Organization user, Long orgId);

}
