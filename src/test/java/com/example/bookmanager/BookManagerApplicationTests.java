package com.example.bookmanager;

import com.example.bookmanager.domain.Gender;
import com.example.bookmanager.domain.User;
import com.example.bookmanager.domain.UserHistory;
import com.example.bookmanager.repository.UserHistoryRepository;
import com.example.bookmanager.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@SpringBootTest
class BookManagerApplicationTests {
    @Autowired
    UserRepository repository;
    @Autowired
    UserHistoryRepository historyRepository;

    @PersistenceContext
    private EntityManager entityManager;
    @Test
    void contextLoads() {
        User user =repository.findById(1L).get();
        user.setName("test");
        repository.save(user);
        repository.flush();

    }

    @Test
    void entityManagerTest(){
    }

}
