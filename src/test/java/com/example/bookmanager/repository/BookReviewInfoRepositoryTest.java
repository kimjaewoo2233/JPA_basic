package com.example.bookmanager.repository;

import com.example.bookmanager.domain.Book;
import com.example.bookmanager.domain.BookReviewInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookReviewInfoRepositoryTest {

    @Autowired
    private BookReviewInfoRepository reviewInfoRepository;
    @Autowired
    private BookRepository bookRepository;
    @Test
    void test(){
        BookReviewInfo info = new BookReviewInfo();

        info.setAverageReviewScore(4.5f);
        info.setReviewCount(2);

        reviewInfoRepository.save(info);

        reviewInfoRepository.findAll().forEach(System.out::println);
    }
    @Test
    void test2(){
//        Book book = new Book();
//        book.setName("jpa 격차0");
//        book.setAuthorId(1L);
//        book.setPublisherId(1L);
//
//        bookRepository.save(book);
//
//        BookReviewInfo info = new BookReviewInfo();
//        info.setBook(book);
//        info.setAverageReviewScore(4.5f);
//        info.setReviewCount(2);
//
//        BookReviewInfo result = repository.save(info);

//        repository.findAll().forEach(System.out::println);

//        System.out.println(result);
        //BookReviewInfo 와 연결하기 위한 book_id값과 일치하는 Book에 id값을 가져온다
    }
    @Test
    void test3(){
        Book book = reviewInfoRepository.findById(1L).get().getBook();
        System.out.println("result == >"+book);
    }
}