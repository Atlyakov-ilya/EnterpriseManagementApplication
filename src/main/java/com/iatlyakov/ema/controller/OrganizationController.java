package com.iatlyakov.ema.controller;

import com.iatlyakov.ema.entity.Organization;
import com.iatlyakov.ema.service.IOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/org")
@CrossOrigin(origins = "http://localhost:8080")
public class OrganizationController {

    @Autowired
    private IOrganizationService orgService;

    @GetMapping("/")
    public List<Organization> findAllOrg(){
        return orgService.findAll();
    }

    @GetMapping("/{orgId}")
    public Organization findOrganizationById(@PathVariable Long orgId){
        return orgService.getOrganizationById(orgId);
    }

    @PostMapping("/")
    public void saveOrganization(@Valid @RequestBody Organization organization){
        orgService.save(organization);
    }

    @DeleteMapping("/{orgId}")
    public void deleteOrganizationById(@PathVariable Long orgId){
        orgService.deleteOrganization(orgId);
    }

    @PutMapping("/{orgId}")
    public void updateOrganization(@Valid @RequestBody Organization organization, @PathVariable Long orgId){
        orgService.updateOrganization(organization,orgId);
    }

}
