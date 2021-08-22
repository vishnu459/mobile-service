package com.hcl.mobile.mobileservice.errors;

public class MobileServiceException extends Exception {

    public MobileServiceException(final Exception exception) {
        super(exception);
    }

    public MobileServiceException(final String errorMessage) {
        super(errorMessage);
    }
}
