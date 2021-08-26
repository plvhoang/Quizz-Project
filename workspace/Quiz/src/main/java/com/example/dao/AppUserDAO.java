package com.example.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.User;

@Repository
@Transactional
public class AppUserDAO {
 
    @Autowired
    private EntityManager entityManager;
 
    public User findUserAccount(String userName) {
        try {
            String sql = "Select e from " + User.class.getName() + " e " //
                    + " Where e.username = :userName ";
            System.out.println(sql);
            Query query = entityManager.createQuery(sql, User.class);
            query.setParameter("userName", userName);
 
            return (User) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}