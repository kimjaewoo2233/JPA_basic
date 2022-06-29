package com.example.bookmanager;

import com.example.bookmanager.domain.Gender;
import com.example.bookmanager.domain.User;
import com.example.bookmanager.domain.UserHistory;
import com.example.bookmanager.repository.UserHistoryRepository;
import com.example.bookmanager.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
class BookManagerApplicationTests {
    @Autowired
    UserRepository repository;
    @Autowired
    UserHistoryRepository historyRepository;
    @Test
    void contextLoads() {
        User user = repository.findById(1).orElse(null);

        System.out.println(user);
        user.setGender(Gender.MALE);
        repository.save(user);
        historyRepository.findAll().forEach(System.out::println);

        }

}
