package com.example.bookmanager.domain;

import com.example.bookmanager.repository.BookRepository;
import com.example.bookmanager.repository.PublisherRepository;
import com.example.bookmanager.repository.ReviewRepository;
import com.example.bookmanager.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReviewTest {
    @Autowired
    UserRepository userRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    PublisherRepository publisherRepository;

    @Test
    @Transactional
    void test(){
            Review review = new Review();
            User user = userRepository.findById(8L).orElse(null);
            Book book = bookRepository.findById(1L).orElse(null);

            review.setTitle("This is Title");
            review.setContent("This is Content");
            review.setScore(4.5f);
            review.setUser(user);
            review.setBook(book);

            reviewRepository.save(review);

    }

    @Test
    void bookRelation(){
            //user 8번으로 1번 퍼블리셔로 만든 10번 북에 리뷰남김
            Book book = bookRepository.findById(13L).get();
        System.out.println("BOo----"+book);
        book.getReviewList().forEach(System.out::println);

    }
}