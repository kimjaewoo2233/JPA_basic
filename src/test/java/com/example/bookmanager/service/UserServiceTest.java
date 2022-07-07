package com.example.bookmanager.service;

import com.example.bookmanager.domain.User;
import com.example.bookmanager.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

        @Autowired
        UserService userService;

        @Autowired
        UserRepository userRepository;

        @PersistenceContext
        EntityManager entityManager;
        @Test
        void test(){
            System.out.println(userRepository.findByEmail("test2@naver.com "));
        }

        @Test
        void test2(){
                userService.put();
        }
}