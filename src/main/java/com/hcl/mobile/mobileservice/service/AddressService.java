package com.hcl.mobile.mobileservice.service;

import com.hcl.mobile.mobileservice.dto.AddressResponse;
import com.hcl.mobile.mobileservice.entity.Address;
import com.hcl.mobile.mobileservice.errors.MobileServiceException;
import com.hcl.mobile.mobileservice.repository.AddressRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.hcl.mobile.mobileservice.util.MobileUtil.isValidaAddress;

@Service
@Slf4j
public class AddressService {

    @Autowired
    public AddressRepository addressRepository;
    @Autowired
    public RestTemplate restTemplate;

    public AddressResponse saveAddress(final Address address) {
        log.info("Inside saveAddress method UserService...! ");
        Address savedAddress;
        try {
            if (isValidaAddress(address)) {
                savedAddress = addressRepository.save(address);
                return new AddressResponse(null, savedAddress);
            }
        } catch (final MobileServiceException exception) {
            log.error("Exception occurred while saving address : " + address);
            return new AddressResponse(exception.getMessage(), null);
        }
        return null;
    }

    public Address findAddress(final Long addressId) {
        log.info("Inside findUser method of UserService...! ");
        return addressRepository.findByAddressId(addressId);
    }

    public void updateAddress(final Address address) {
        log.info("Inside updateUserStatus method of UserService...! ");
         addressRepository.updateByIdAddress(address);
    }
}
