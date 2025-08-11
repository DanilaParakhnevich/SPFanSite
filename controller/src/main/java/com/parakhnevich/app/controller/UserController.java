package com.parakhnevich.app.controller;

import com.parakhnevich.app.dto.UserDto;
import com.parakhnevich.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    @Qualifier("resourceBundleMessageSource")
    private MessageSource messageSource;

    @PostMapping
    @RequestMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody UserDto user) {
        ResponseEntity<String> responseEntity;
        try {
            userService.createUser(user);
            responseEntity = ResponseEntity.ok().build();
        } catch (Exception e) {
            Locale locale = LocaleContextHolder.getLocale();
            responseEntity = ResponseEntity.status(400).body(messageSource.getMessage(e.getMessage(), null, locale));
        }
        return responseEntity;
    }
}
