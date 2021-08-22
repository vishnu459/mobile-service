package com.hcl.mobile.mobileservice.service;

import com.hcl.mobile.mobileservice.dto.MobilePlansResponse;
import com.hcl.mobile.mobileservice.entity.MobilePlans;
import com.hcl.mobile.mobileservice.repository.MobilePlansRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MobilePlansService {

    @Autowired
    public MobilePlansRepository mobilePlansRepository;

    public MobilePlansResponse saveMobilePlan(final MobilePlans mobilePlans) {
        log.info("Inside saveMobilePlan method MobilePlansService...! ");
        final MobilePlans savedPlan = mobilePlansRepository.save(mobilePlans);
        return new MobilePlansResponse(null, savedPlan);
        /*try {
            if (isValidatedMobilePlan(mobilePlans)) {
                MobilePlans savedPlan = mobilePlansRepository.save(mobilePlans);
                return new MobilePlansResponse(null, savedPlan);
            }
        } catch (final MobileServiceException exception) {
            return new MobilePlansResponse(exception.getMessage(), null);
        }
        return null;*/
    }

    public MobilePlans findMobilePlanById(final Long planId) {
        log.info("Inside findMobilePlanById method of MobilePlansService...! ");
        return mobilePlansRepository.findByPlanId(planId);
    }

/*    public MobilePlans updateMobilePlans(final MobilePlans mobilePlans) {
        log.info("Inside updateMobilePlans method of MobilePlansService...! ");
        return mobilePlansRepository.updateMobilePlanById(mobilePlans);
    }*/
}
