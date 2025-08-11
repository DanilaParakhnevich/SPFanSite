package com.parakhnevich.app.validator;

import com.parakhnevich.app.dto.UserDto;
import com.parakhnevich.app.validator.exception.BadPasswordException;
import com.parakhnevich.app.validator.exception.BadUsernameException;
import org.springframework.stereotype.Component;

@Component
public class UserValidator implements Validator<UserDto> {

    @Override
    public void validate(UserDto user) {
        if (user.getPassword() == null || user.getPassword().length() < 4) {
            throw new BadPasswordException();
        }

        if (user.getUsername() == null || user.getUsername().length() < 4) {
            throw new BadUsernameException();
        }
    }

}
