package com.parakhnevich.app.service;

import com.parakhnevich.app.dto.UserDto;
import com.parakhnevich.app.entity.UserEntity;
import com.parakhnevich.app.mapper.UserMapper;
import com.parakhnevich.app.repository.UserRepository;
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userMapper.toDto(userRepository.findByUsername(username));
    }

    public UserDto createUser(UserDto user) throws UsernameNotFoundException {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userMapper.toDto(userRepository.save(userMapper.toEntity(user)));
    }
}
