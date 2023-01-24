package com.eldorado.microservice.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressEntity {
    private String zipCode;
    private String street;

    private String city;
    private String state;

    private String country;

    private String number;

}
