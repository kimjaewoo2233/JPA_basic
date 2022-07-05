package com.example.bookmanager.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity     //Entity객체는 NoArgsConstructor 가 필요하다
public class Book{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;

        private String author;


        @OneToMany(fetch = FetchType.EAGER)
        @JoinColumn(name="book_id",insertable = false,updatable = false)        //
        @ToString.Exclude       //StackOverFlow 방지하기 위해 사용한다
        private List<Review> reviewList = new ArrayList<>();            //NPE를 방지하기 위해 arrayList 넣는거임


        @OneToOne(mappedBy = "book")    //Fk는 BookReviewInfo에 book필드가 가졌다는 표시
        public BookReviewInfo bookReviewInfo;

        @ManyToOne
        @ToString.Exclude
        private Publisher publisher;    //이게 Publisher_id

        @OneToMany(fetch = FetchType.LAZY)
        @JoinColumn(name = "book_id")
        @ToString.Exclude
        private List<BookAndAuthor> authors = new ArrayList<>();

        @Column(name = "create_at")
        private LocalDateTime createdAt;

        @Column(name = "update_at")
        private LocalDateTime updatedAt;

        @PrePersist
        public void persist(){
                this.createdAt = LocalDateTime.now();
                this.updatedAt =  LocalDateTime.now();
        }
        @PreUpdate
        public void update(){
                this.updatedAt =  LocalDateTime.now();
        }

        public void addAuthor(BookAndAuthor... author){
                Collections.addAll(this.authors,author);
        }
}
