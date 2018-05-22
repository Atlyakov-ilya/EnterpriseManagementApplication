package com.iatlyakov.ema.repository;

import com.iatlyakov.ema.entity.OrgType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrgTypeRepository extends JpaRepository<OrgType,Long> {

    @Query( "select t from OrgType t where t.nameOrgType = :nameOrgType" )
    OrgType getByNameOrgType(@Param("nameOrgType")String nameOrgType);
}
