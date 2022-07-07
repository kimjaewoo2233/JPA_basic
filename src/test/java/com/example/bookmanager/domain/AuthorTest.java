package com.example.bookmanager.domain;

import com.example.bookmanager.repository.AuthorRepository;
import com.example.bookmanager.repository.BookAndAuthorRepository;
import com.example.bookmanager.repository.BookRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class AuthorTest {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookAndAuthorRepository bookAndAuthorRepository;
    @Test
    void test() {


        //book1.addAuthor(author1); 원래는 이런식으로 코딩한다 setter를 건들지 않는다



//        System.out.println("authors through book : "+bookRepository.findById(14L).get());
//        System.out.println("books through author : "+authorRepository.findById(1L).orElse(null));
    }
    @Test
    void crr(){
//        Book book = bookRepository.findById(20L).get();
//        Author author =authorRepository.findById(1L).get();
//
//        BookAndAuthor bookAndAuthor = givenBookAndAuthor(book,author);
//        System.out.println(bookAndAuthor);

    }
    @Test
    void boo(){

    }




    private BookAndAuthor givenBookAndAuthor(Book book,Author author){
        BookAndAuthor bookAndAuthor = new BookAndAuthor();
        bookAndAuthor.setBook(book);
        bookAndAuthor.setAuthor(author);
        return bookAndAuthorRepository.save(bookAndAuthor);
    }
}