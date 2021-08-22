package com.hcl.mobile.mobileservice.controller;

import com.hcl.mobile.mobileservice.dto.UserResponse;
import com.hcl.mobile.mobileservice.entity.User;
import com.hcl.mobile.mobileservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/users")
@Slf4j
public class UserController {

    @Autowired
    public UserService userService;

    @PostMapping(path = "/save-user", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(OK)
    public UserResponse saveUserData(@RequestBody final User user) {
        log.info("Inside saveUser method of UserController..");
        return userService.saveUser(user);
    }

    @GetMapping("/find-user")
    @ResponseStatus(OK)
    public User findUser(@RequestParam(name = "userId") final Long userId) {
        log.info("Inside saveUser method of UserController..");
        return userService.findUser(userId);
    }

    @PostMapping(path = "/update-user-status")
    @ResponseStatus(OK)
    public void updateUserStatus(@RequestParam(name = "userId") final Long userId,
                                 @RequestParam(name = "status") final String status) {
        log.info("Inside updateUserStatus method of UserController..");
        userService.updateUserStatus(status, userId);
    }

    @PostMapping(path = "/assign-mobile")
    @ResponseStatus(OK)
    public void assignMobile(@RequestParam(name = "userId") final Long userId) {
        log.info("Inside assignMobile method of UserController..");
        userService.assignMobile(userId);
    }
}
