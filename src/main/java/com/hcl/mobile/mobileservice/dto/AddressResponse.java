package com.hcl.mobile.mobileservice.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hcl.mobile.mobileservice.entity.Address;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AddressResponse extends Response {

    Address address;

    @JsonCreator
    public AddressResponse(
            @JsonProperty final String errorDetails,
            @JsonProperty final Address address
    ) {
        super(errorDetails);
        this.address = address;
    }
}
