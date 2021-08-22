package com.hcl.mobile.mobileservice.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hcl.mobile.mobileservice.entity.MobilePlans;
import lombok.Value;

@Value
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MobilePlansResponse extends Response {

    MobilePlans mobilePlans;

    @JsonCreator
    public MobilePlansResponse(@JsonProperty String errorDetails, @JsonProperty MobilePlans mobilePlans) {
        super(errorDetails);
        this.mobilePlans = mobilePlans;
    }
}
