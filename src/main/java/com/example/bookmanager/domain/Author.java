package com.example.bookmanager.domain;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@ToString
public class Author {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;

        @Column(name = "country")
        private String contry;

        @OneToMany
        @JoinColumn(name="author_id")
        @ToString.Exclude
        private List<BookAndAuthor> books = new ArrayList<>();


        public void addBook(List<BookAndAuthor> book){      //...하면 배열로 받겠다는 것이다
                books.addAll(book);
        }


}
