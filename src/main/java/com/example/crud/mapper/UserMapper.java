package com.example.crud.mapper;

import com.example.crud.dao.UserDTO;
import com.example.crud.entity.User;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserMapper {
    public static UserDTO toDto(User user) {
        return UserDTO.builder()
                .name(user.getName())
                .email(user.getEmail())
                .age(user.getAge())
                .build();
    }

    public static User toEntity(UserDTO userDTO) {
        return User.builder()
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .age(userDTO.getAge())
                .build();
    }

    public static User toEntity(UserDTO userDTO, Long id) {
        return User.builder()
                .id(id)
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .age(userDTO.getAge())
                .build();
    }
}
