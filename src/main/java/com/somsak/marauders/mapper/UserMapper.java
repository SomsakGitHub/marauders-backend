package com.somsak.marauders.mapper;

import com.somsak.marauders.dto.UserRegisterDTO;
import com.somsak.marauders.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    // DTO -> Entity
    public User toEntity(UserRegisterDTO dto) {
        return User.builder()
                .username(dto.getUsername())
                .email(dto.getEmail())
                .password(dto.getPassword()) // * ควรเข้ารหัส password ด้วย BCrypt
                .build();
    }

    // Entity -> DTO (ถ้าต้องการส่งกลับไป view)
    public UserRegisterDTO toDTO(User user) {
        return UserRegisterDTO.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .password("") // ไม่ส่ง password กลับ
                .build();
    }
}

