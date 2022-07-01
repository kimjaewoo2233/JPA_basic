package com.example.bookmanager.domain;

import com.example.bookmanager.repository.UserHistoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class UserHistoryTest {
    @Autowired
    UserHistoryRepository repository;
    @Test
    void test(){
        UserHistory history = new UserHistory();

        history.setUserId(1L);
        history.setName("test");
        history.setEmail("taTest@naver.com");
        repository.save(history);

    }
}