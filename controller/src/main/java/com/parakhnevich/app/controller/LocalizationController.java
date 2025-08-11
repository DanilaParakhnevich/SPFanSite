package com.parakhnevich.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocalizationController {

    @Autowired
    @Qualifier("resourceBundleMessageSource")
    private MessageSource messageSource;

    @PostMapping
    @RequestMapping("/getMessage")
    public String createUser(@RequestBody String locale) {
        return messageSource.getMessage(locale, null, LocaleContextHolder.getLocale());
    }

}
