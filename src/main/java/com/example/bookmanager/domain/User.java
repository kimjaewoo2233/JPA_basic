package com.example.bookmanager.domain;


import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
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
//@Column(name="create_At")
//@Column(nullable = false) 빈 값을 허용하지 않는다
//@Column(updatable=false) update시 update를 하지 않는다
//    @Column(name="create_at")
//    private LocalDateTime createdAt;
//    //db에는 create_at으로 된다 낙타체가 스네이크체로 변경됨
//    @Column(name="update_at")
//    private LocalDateTime updatedAt;


//    @PrePersist
//    public void prePersist(){
//        this.createAt = LocalDateTime.now();
//        this.updateAt = LocalDateTime.now();
//    }
//    @PreUpdate
//    public void postPersist(){
//        this.updateAt = LocalDateTime.now();
//    }

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
