package com.hcl.mobile.mobileservice.service;

import com.hcl.mobile.mobileservice.dto.UserResponse;
import com.hcl.mobile.mobileservice.entity.User;
import com.hcl.mobile.mobileservice.errors.MobileServiceException;
import com.hcl.mobile.mobileservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static com.hcl.mobile.mobileservice.util.MobileUtil.isValidateUser;

@Service
@Slf4j
public class UserService {

    private static final List<Long> mobilesNumbers = new ArrayList<>();
    @Autowired
    public UserRepository userRepository;

    @Autowired
    public RestTemplate restTemplate;

    public UserResponse saveUser(User user) {
        log.info("Inside saveUser method UserService...! ");
        User savedUser;
        try {
            if (isValidateUser(user)) {
                savedUser = userRepository.save(user);
                return new UserResponse(savedUser, null);
            }
        } catch (final MobileServiceException exception) {
            return new UserResponse(null, exception.getMessage());
        }
        return null;
    }

    public User findUser(final Long userId) {
        log.info("Inside findUser method of UserService...! ");
        return userRepository.findByUserId(userId);
    }

    public void updateUserStatus(final String status, final Long userId) {
        log.info("Inside updateUserStatus method of UserService...! ");
        userRepository.updateStatus(status, userId);
    }

    public void assignMobile(Long userId) {
        log.info("Inside assignMobile method of UserService...! ");
        long mobileNo = (long) (Math.random() * 100000 + 3333300000L);
        while (mobilesNumbers.contains(mobileNo)) {
            mobileNo = (long) (Math.random() * 100000 + 3333300000L);
        }
        mobilesNumbers.add(mobileNo);
        userRepository.updateMobileNumber(mobileNo, userId);
    }
}
