package com.eldorado.microservice.user.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("user")
public class UserEntity {

    @NonNull
    private String name;

    private char gender;

    @NonNull
    private LocalDate birthDate;

    @NonNull
    @Id
    private String document;

    @NonNull
    private String email;

    private String password;

    private AddressEntity addressEntity;

    @Override
    public String toString() {
        return "UserEntity{" +
                "document='" + document + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                '}';
    }
}
