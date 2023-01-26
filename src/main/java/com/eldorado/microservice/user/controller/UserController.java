package com.eldorado.microservice.user.controller;

import com.eldorado.microservice.user.dto.UserDto;
import com.eldorado.microservice.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;
    @RequestMapping(method=RequestMethod.POST, produces = "application/json")
    public ResponseEntity createUser(@RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.createUser(userDto));
    }
}
