package com.somsak.marauders.service;

import com.somsak.marauders.dto.UserRegisterDTO;
import com.somsak.marauders.entity.User;
import com.somsak.marauders.mapper.UserMapper;
import com.somsak.marauders.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public User registerUser(UserRegisterDTO dto) {
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email already registered!");
        }

        // Mapper ช่วยแปลง DTO -> Entity
        User user = userMapper.toEntity(dto);
        return userRepository.save(user);
    }
}
