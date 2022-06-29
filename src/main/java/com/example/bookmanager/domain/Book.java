package com.example.bookmanager.domain;

import com.fasterxml.jackson.databind.annotation.JsonTypeResolver;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity     //Entity객체는 NoArgsConstructor 가 필요하다
public class Book implements Auditable{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String name;

        private String author;

        @Column(name = "create_at")
        private LocalDateTime createdAt;

        @Column(name = "update_at")
        private LocalDateTime updatedAt;

        
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
