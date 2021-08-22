package com.hcl.mobile.mobileservice.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Response {

    String errorDetails;

    @JsonCreator
    public Response(@JsonProperty final String errorDetails) {
        this.errorDetails = errorDetails;
    }
}
