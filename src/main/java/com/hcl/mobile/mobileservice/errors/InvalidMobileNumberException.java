package com.hcl.mobile.mobileservice.errors;

public class InvalidMobileNumberException extends MobileServiceException {

    public InvalidMobileNumberException(String errorMessage) {
        super(errorMessage);
    }
}
