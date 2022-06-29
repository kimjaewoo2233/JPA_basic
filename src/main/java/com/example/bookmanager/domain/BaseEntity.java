package com.example.bookmanager.domain;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.time.LocalDateTime;
@MappedSuperclass       //이 클래스를 상속받는 Entity클래스에 이 필드를 포함시켜준다
@EntityListeners(value={MyEntityListener.class,UserEntityListener.class})
@Getter
@Setter
public class BaseEntity {


    @Column(name = "create_at")
    private LocalDateTime createdAt;

    @Column(name = "update_at")
    private LocalDateTime updatedAt;
}
