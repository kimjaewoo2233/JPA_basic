package com.example.bookmanager.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity     //Entity객체는 NoArgsConstructor 가 필요하다
public class Book extends BaseEntity{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;

        private String author;

        private Long authorId;

        private Long publisherId;

//        @OneToOne               //DB테이블에 값이 있어야함 review테이블에는 FK로 연결했기에 값확인가능하다
//        private BookReviewInfo bookReviewInfo;
        
//        @PrePersist
//        private void persist(){
//                this.createdAt = LocalDateTime.now();
//                this.updatedAt = LocalDateTime.now();
//        }
//        @PreUpdate
//        private void update(){
//                this.updatedAt = LocalDateTime.now();
//        }

}
