package com.example.bookmanager.domain;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class User {     //해당 객체를 조회하고 생성하는 방법은 Repository이용한다
    @Id             //primary key 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //값이 자동증가 auto와 동일  mysql의 경우 이렇게 설정해야한다
    private int id;

    @NonNull
    private String name;

    @NonNull
    private  String email;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;
}
