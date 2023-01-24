package com.eldorado.microservice.user.dto;

import lombok.*;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {

    @NonNull
    private String name;

    private String gender;

    @NonNull
    private LocalDate birthdate;

    @NonNull
    private String document;

    @NonNull
    private String email;

    private AddressDto addressDto;

}
