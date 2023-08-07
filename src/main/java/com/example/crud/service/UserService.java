package com.example.crud.service;

import com.example.crud.dao.UserDTO;
import com.example.crud.entity.User;
import com.example.crud.mapper.UserMapper;
import com.example.crud.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;

    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDTO> list = new ArrayList<>();
        for (User user : users) {
            UserDTO dto = UserMapper.toDto(user);
            list.add(dto);
        }
        return list;
    }

    public UserDTO createUser(UserDTO userDTO) {
        User user = UserMapper.toEntity(userDTO);
        User savedUser = userRepository.save(user);
        return UserMapper.toDto(savedUser);
    }

    public Optional<UserDTO> getUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.map(UserMapper::toDto);
    }

    public UserDTO updateUserById(Long id, UserDTO updatedUserDTO) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = UserMapper.toEntity(updatedUserDTO, id);
            User updatedUser = userRepository.save(user);
            return UserMapper.toDto(updatedUser);
        }
        return null;
    }

    public boolean deleteUserById(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }


}

