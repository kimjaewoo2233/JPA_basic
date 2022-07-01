package com.example.bookmanager.domain;


import com.example.bookmanager.domain.listener.MyEntityListener;
import com.example.bookmanager.domain.listener.UserEntityListener;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
@MappedSuperclass       //이 클래스를 상속받는 Entity클래스에 이 필드를 포함시켜준다
@EntityListeners(value={MyEntityListener.class, UserEntityListener.class})
@Getter
@Setter
@ToString
public class BaseEntity implements Auditable {


    @Column(name = "create_at")
    private LocalDateTime createdAt;

    @Column(name = "update_at")
    private LocalDateTime updatedAt;
}
