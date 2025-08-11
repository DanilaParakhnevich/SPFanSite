package com.parakhnevich.app.service;

import com.parakhnevich.app.dto.UserDto;
import com.parakhnevich.app.entity.UserEntity;
import com.parakhnevich.app.mapper.UserMapper;
import com.parakhnevich.app.repository.UserRepository;
import com.parakhnevich.app.validator.UserValidator;
import com.parakhnevich.app.validator.exception.UsernameExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserValidator userValidator;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByUsername(username);
        return user.map(userEntity -> userMapper.toDto(userEntity)).orElse(null);
    }

    public UserDto createUser(UserDto user) throws UsernameNotFoundException {

        // Validate user
        userValidator.validate(user);
        try {
            if (loadUserByUsername(user.getUsername()) != null) {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new UsernameExistsException();
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userMapper.toDto(userRepository.save(userMapper.toEntity(user)));
    }
}
