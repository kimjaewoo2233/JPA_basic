package com.example.bookmanager.repository;

import com.example.bookmanager.domain.Gender;
import com.example.bookmanager.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class RepositoryTest {

    @Autowired
    UserRepository repository;

    @Test
    void test(){
        User user = new User();
        user.setName("martin");
        user.setEmail("ttttt");
        user.setGender(Gender.MALE);
        repository.save(user);

        User user2 = repository.findById(1).orElse(null);
        user2.setGender(Gender.FEMALE);
        repository.save(user2);

        repository.findAll().forEach(System.out::println);
        //System.out.println(repository.findRawRecord().get("gender"));
        //gender
    }

    @Test
    void si(){
       User user = repository.findById(1).orElse(null);
       user.setName("kaem");
       repository.save(user);
    }
}
