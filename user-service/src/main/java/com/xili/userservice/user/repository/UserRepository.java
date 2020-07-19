package com.xili.userservice.user.repository;


import com.xili.userservice.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户信息repository
 *
 * @author xinliang
 * @since 1.0.0
 */
public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryEx {

}
