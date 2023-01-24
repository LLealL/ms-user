package com.eldorado.microservice.user.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddressDto {

    private String zipCode;
    private String street;
    private String city;
    private String state;
    private String country;
    private String number;
}
