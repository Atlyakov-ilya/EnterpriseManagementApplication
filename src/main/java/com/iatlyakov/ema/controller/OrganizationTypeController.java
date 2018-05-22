package com.iatlyakov.ema.controller;

import com.iatlyakov.ema.entity.OrgType;
import com.iatlyakov.ema.service.IOrgTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/type")
@CrossOrigin(origins = "http://localhost:8080")
public class OrganizationTypeController {

    @Autowired
    private IOrgTypeService orgTypeService;

    @GetMapping("/")
    public List<OrgType> findAllOrgType(){
        return orgTypeService.findAll();
    }

    @GetMapping("/searchType")
    public OrgType getTypeByName(@RequestParam String nameOrgType){
        return orgTypeService.getTypeByName(nameOrgType);
    }

    @PostMapping("/")
    public void saveOrgType(@Valid @RequestBody OrgType orgType){
        orgTypeService.save(orgType);
    }

    @DeleteMapping("/{orgTypeId}")
    public void deleteType(@PathVariable Long orgTypeId){
        orgTypeService.deleteType(orgTypeId);
    }

}
