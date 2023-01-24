package com.eldorado.microservice.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MessageDto {

    private String to;
    private String subject;
    private String password;
    private String message;

    @Override
    public String toString(){
        return "MessageDto{" +
                "to='" + to + '\'' +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                '}'; }

}
