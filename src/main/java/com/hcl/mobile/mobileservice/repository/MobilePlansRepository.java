package com.hcl.mobile.mobileservice.repository;

import com.hcl.mobile.mobileservice.entity.MobilePlans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobilePlansRepository extends JpaRepository<MobilePlans, Long> {

    MobilePlans findByPlanId(final Long planId);

}
