package com.hcl.mobile.mobileservice.controller;

import com.hcl.mobile.mobileservice.dto.AddressResponse;
import com.hcl.mobile.mobileservice.entity.Address;
import com.hcl.mobile.mobileservice.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class AddressController {

    @Autowired
    public AddressService addressService;

    @PostMapping("/save-address")
    @ResponseBody
    @ResponseStatus
    public AddressResponse saveAddress(@RequestBody final Address address) {
        log.info("Inside saveAddress method of AddressController..");
        return addressService.saveAddress(address);
    }

    @GetMapping("/find-address")
    public Address findAddress(@RequestParam(name = "addressId") final Long addressId) {
        log.info("Inside findAddress method of AddressController..");
        return addressService.findAddress(addressId);
    }

    @PostMapping("/update-address")
    public void updateAddress(@RequestBody final Address address) {
        log.info("Inside updateAddress method of AddressController..");
        addressService.updateAddress(address);
    }
}
