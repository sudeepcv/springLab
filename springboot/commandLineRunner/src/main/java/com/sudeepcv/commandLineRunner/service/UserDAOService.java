package com.sudeepcv.commandLineRunner.service;

import com.sudeepcv.commandLineRunner.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDAOService {
    @PersistenceContext
    private EntityManager entityManager;
    public  Long save(User user){
        entityManager.persist(user);
        return  user.getId();


    }
}
