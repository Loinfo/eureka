package com.xili.userservice.user.repository;


import com.xili.userservice.user.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * 用户信息管理扩展repository
 *
 * @author xinliang
 * @since 1.0.0
 */
public class UserRepositoryImpl implements UserRepositoryEx {
    @PersistenceContext
    protected EntityManager entityManager;

    public List<User> findTopUser(int maxResult) {
        Query query = this.entityManager.createQuery("from User");
        query.setMaxResults(maxResult);
        return query.getResultList();
    }
}
