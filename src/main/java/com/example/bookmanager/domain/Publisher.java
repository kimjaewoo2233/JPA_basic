package com.example.bookmanager.domain;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@ToString
public class Publisher{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "create_at")
    private LocalDateTime createdAt;

    @Column(name = "update_at")
    private LocalDateTime updatedAt;
//
//    @OneToMany
//    @JoinColumn(name="publisher_id")
//    private List<Book> bookList = new ArrayList<>();



    @PrePersist
    public void persist(){
        this.createdAt = LocalDateTime.now();
        this.updatedAt =  LocalDateTime.now();
    }
    @PreUpdate
    public void update(){
        this.updatedAt =  LocalDateTime.now();
    }
}
