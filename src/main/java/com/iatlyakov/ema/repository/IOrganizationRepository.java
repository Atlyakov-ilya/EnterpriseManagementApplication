package com.iatlyakov.ema.repository;

import com.iatlyakov.ema.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrganizationRepository extends JpaRepository<Organization,Long> {
}
