package com.xili.userservice.user.repository;


import com.xili.userservice.user.entity.User;

import java.util.List;

/**
 * 用户信息管理扩展repository
 *
 * @author xinliang
 * @since 1.0.0
 */
public interface UserRepositoryEx {
    List<User> findTopUser(int maxResult);
}
