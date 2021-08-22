package com.hcl.mobile.mobileservice.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hcl.mobile.mobileservice.entity.User;
import lombok.Value;

@Value
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserResponse extends Response {

    User user;

    @JsonCreator
    public UserResponse(
            @JsonProperty final User user,
            @JsonProperty final String errorDetails
    ) {
        super(errorDetails);
        this.user = user;
    }
}
