package com.example.bookmanager.domain;

import com.example.bookmanager.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookTest {

    @Autowired
    BookRepository repository;
    @Test
    void test(){
        Book book = new Book();
        book.setName("JPA");
        book.setAuthor("테스터");
        repository.save(book);
    }
}