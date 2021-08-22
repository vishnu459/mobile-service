package com.hcl.mobile.mobileservice.errors;

public class InvalidEmailException extends MobileServiceException {

    public InvalidEmailException(String errorMessage) {
        super(errorMessage);
    }
}
