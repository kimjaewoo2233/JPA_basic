package com.example.bookmanager.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BookReviewInfo extends BaseEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

//        private Long bookId;
        @OneToOne(optional = false)      //1대1로 연관관계를 갖는다 FK키 이렇게 지정해야한다(optional =false)는 not null
        private Book book; //DB에는 1대1 연관관계를 맺을 수 있도록 book_id로 들어간다 FK로 지정되어있아야함
                                //inner join 사용 optional = false일 경우 not null이기에 그러핟
        private float averageReviewScore;       //평균점수

        private int reviewCount;                //기본값을 0으로 하기위해 privitive 타입사용 null불가능
}                                               //래퍼 타입은 0이 불가하고 null로 받는다 (null 체크안하면 NPE발생
