package com.parakhnevich.app.mapper;

import com.parakhnevich.app.dto.UserDto;
import com.parakhnevich.app.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserEntity toEntity(UserDto dto) {
        var entity = new UserEntity();
        entity.setId(dto.getId());
        entity.setPassword(dto.getPassword());
        entity.setUsername(dto.getUsername());
        if (dto.getRoles() == null) {
            entity.setRoles("user");
        } else {
            entity.setRoles(String.join(",", dto.getRoles().stream().map(GrantedAuthority::getAuthority).toList()));
        }
        return entity;
    }

    public UserDto toDto(UserEntity entity) {
        var dto = new UserDto();
        dto.setId(entity.getId());
        dto.setPassword(entity.getPassword());
        dto.setUsername(entity.getUsername());
        dto.setRoles(Arrays.stream(entity.getRoles().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList()));
        return dto;
    }
}
