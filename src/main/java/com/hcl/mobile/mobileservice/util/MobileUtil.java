package com.hcl.mobile.mobileservice.util;

import com.hcl.mobile.mobileservice.entity.Address;
import com.hcl.mobile.mobileservice.entity.MobilePlans;
import com.hcl.mobile.mobileservice.entity.User;
import com.hcl.mobile.mobileservice.errors.InvalidAddressException;
import com.hcl.mobile.mobileservice.errors.InvalidEmailException;
import com.hcl.mobile.mobileservice.errors.InvalidMobileNumberException;
import com.hcl.mobile.mobileservice.errors.MobileServiceException;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.util.regex.Pattern;

@UtilityClass
public class MobileUtil {
    private static final Pattern mobilePattern = Pattern.compile("(0/91)?[7-9][0-9]{9}");
    private static final Pattern emailPattern = Pattern.compile("^(.+)@(.+)$");

    public static boolean isValidateUser(final User user) throws MobileServiceException {
        boolean isNumberValid = isMobileNumberValid(user.getMobileNo());
        boolean isEmailValid = isEmailValid(user.getEmail());
        return isNumberValid && isEmailValid;
    }

    @SneakyThrows
    private static boolean isMobileNumberValid(final long mobileNo) {
        if (String.valueOf(mobileNo).matches(mobilePattern.pattern())) {
            return true;
        }
        throw new InvalidMobileNumberException("Mobile is not valid : " + mobileNo);
    }

    @SneakyThrows
    private static boolean isEmailValid(final String mobileNo) {
        if (String.valueOf(mobileNo).matches(emailPattern.pattern())) {
            return true;
        }
        throw new InvalidEmailException("Mobile is not valid : " + mobileNo);
    }

    public static boolean isValidaAddress(final Address address) throws InvalidAddressException {
        if (isEmpty(address.getHouseNo())
                || isEmpty(address.getStreet())
                || isEmpty(address.getCity())
                || address.getPinCode() == 0) {
            throw new InvalidAddressException("Address is not valid : " + address);
        }
        return true;
    }

    public static boolean isValidatedMobilePlan(final MobilePlans mobilePlans) {
        return true;
    }

    private boolean isEmpty(final String value) {
        return value == null || value.length() == 0;

    }
}
