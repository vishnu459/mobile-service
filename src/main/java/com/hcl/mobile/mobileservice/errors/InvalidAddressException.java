package com.hcl.mobile.mobileservice.errors;

public class InvalidAddressException extends MobileServiceException {

    public InvalidAddressException(String errorMessage) {
        super(errorMessage);
    }
}
