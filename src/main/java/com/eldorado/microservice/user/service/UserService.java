package com.eldorado.microservice.user.service;

import com.eldorado.microservice.user.domain.UserEntity;
import com.eldorado.microservice.user.dto.MessageDto;
import com.eldorado.microservice.user.dto.UserDto;
import com.eldorado.microservice.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.modelmapper.ModelMapper;
import com.google.common.hash.Hashing;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.apache.tomcat.util.codec.binary.Base64;

import java.nio.charset.StandardCharsets;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final String MESSAGE = "Cadastro realizado\nUsuario: %s\nSenha: %s";

    private final String SUBJECT = "NÃO RESPONDA";
    public UserDto createUser(@Validated UserDto userDto){
        var userEntity = modelMapper.map(userDto, UserEntity.class);

        var password = passwordGenerator();

        userEntity.setPassword(Hashing.sha256()
                .hashString(password, StandardCharsets.UTF_8)
                .toString());

        userEntity = userRepository.save(userEntity);
        log.info("User Saved with sucess {}",userEntity);

        sendMessage(userDto,password);
        return null;
    }

    private void sendMessage(UserDto userDto, String password){
        var message = MessageDto
                .builder()
                .to(userDto.getEmail())
                .message(String.format(MESSAGE, userDto.getEmail(), password))
                .subject(SUBJECT)
                .build();

        log.info("Message to queue {}", message);
    }

    public String passwordGenerator(){
        RandomStringUtils.randomAlphabetic(10);
        return Base64.encodeBase64String(RandomStringUtils.randomAlphanumeric(10).getBytes());

    }

}
