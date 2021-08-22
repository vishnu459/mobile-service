package com.hcl.mobile.mobileservice.controller;

import com.hcl.mobile.mobileservice.dto.MobilePlansResponse;
import com.hcl.mobile.mobileservice.entity.MobilePlans;
import com.hcl.mobile.mobileservice.service.MobilePlansService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mobile-plans")
@Slf4j
public class MobilePlansController {

    @Autowired
    public MobilePlansService mobilePlansService;

    @PostMapping("/save-plan")
    public MobilePlansResponse saveMobilePlan(@RequestBody final MobilePlans mobilePlans) {
        log.info("Inside saveUser method of UserController..");
        return mobilePlansService.saveMobilePlan(mobilePlans);
    }

    @GetMapping("/find-plan")
    public MobilePlans findPlan(@RequestParam(name = "planId") final Long planId) {
        log.info("Inside saveUser method of UserController..");
        return mobilePlansService.findMobilePlanById(planId);
    }

/*    @PostMapping("/update-plan")
    public MobilePlans updatePlan(@RequestBody final MobilePlans mobilePlans) {
        log.info("Inside saveUser method of UserController..");
        return mobilePlansService.updateMobilePlans(mobilePlans);
    }*/

}
