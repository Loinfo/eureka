package com.xili.userservice.user.service;

import com.xili.userservice.user.api.UserDto;
import com.xili.userservice.user.entity.User;
import com.xili.userservice.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


/**
 * 用户管理服务实现
 *
 * @author xinliang
 * @since 1.0.0
 */
@Service
public class UserService {
    @Autowired
    protected UserRepository userRepository;

    public List<UserDto> findAll() {
        List<User> users = this.userRepository.findAll();
        return users.stream().map((user) -> {
            return new UserDto(user);
        }).collect(Collectors.toList());
    }

    public UserDto load(Long id) {
        User user = this.userRepository.findOne(id);
        if (null == user)
            return null;

        return new UserDto(user);
    }

    public UserDto save(UserDto userDto) {
        User user = this.userRepository.findOne(userDto.getId());
        if (null == user) {
            user = new User();
        }
        user.setNickname(userDto.getNickname());
        user.setAvatar(userDto.getAvatar());
        this.userRepository.save(user);

        return new UserDto(user);
    }

    public void delete(Long id) {
        this.userRepository.delete(id);
    }
}
