package com.example.bookmanager.domain;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity //JPA에서 관리하는 객체임을 나타낸다
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
//@Table 테이블 명과 클래스명이 일치하면 안 적어도된다. 만약 일치하지 않으면 (name) 설정해야한다
//@Table
//@EntityListeners(value = {MyEntityListener.class,UserEntityListener.class})
public class User extends BaseEntity{     //해당 객체를 조회하고 생성하는 방법은 Repository이용한다
    @Id             //primary key 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //값이 자동증가 auto와 동일  mysql의 경우 이렇게 설정해야한다
    private Long id;     //레코드를 분류할 수 있도록 PK지정
                        //auto_increment 떄문에 IDENTITY Default는 AUTO임 하지만 구체적으로 명시하는 것이 좋다
    private String name;

    @Enumerated(value = EnumType.STRING)     //제대로된 Enum값을 확인하려면 이 애노티에션으로 설정해야한다 아니면 0,1...이런식으로 값이 저장된다
    private Gender gender;

    @NonNull
    private  String email;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",insertable = false,updatable = false)             //어떤 컬럼으로 조인할지 정해준다 insert와 update를 여기서 못하게 설정
    @ToString.Exclude       //ToString 순환관계를 끊는다 이거 안하면 StackOverflow
    private List<UserHistory> userHistories = new ArrayList<>();    //데이터 타입은 Collection 타입 --원래 값 대입을 안하는 것이 맞지만
                                                                    //NPE가 발생할 수 있기에 해야한다 이것도 거의 일어나지 않음 스프링 빈이 자동주입해줘서

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",insertable = false,updatable = false)  //주인이 아닌 곳에서 값을 다룰 수 없다 FK가 선언된 곳이 주인이고 거기서만 넣을 숭 ㅣㅆ다
    @ToString.Exclude
    private List<Review> reviewList = new ArrayList<>();
//@Column(name="create_At")
//@Column(nullable = false) 빈 값을 허용하지 않는다
//@Column(updatable=false) update시 update를 하지 않는다

}
/*
* @PrePersist save메소드 호출전
* @PreUpdate update/insert
* @PreRemove
* @PostPersist  insert된 후
* @PostUpdate
* @PostRemove
* @PostLoad
*
* */
