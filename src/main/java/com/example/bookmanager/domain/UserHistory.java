package com.example.bookmanager.domain;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(callSuper = true)     //이 두가지 안하면 에러난다  Entity 상속받기 1. MappedSuperclass 2. ToString,EqualsAnHashcode callSuper true지정 해야함
@EqualsAndHashCode(callSuper = true)
@EntityListeners(value = MyEntityListener.class)
public class UserHistory extends BaseEntity implements Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="userId")
    private int userId;

    private String name;

    private String email;


    @Column(name = "create_at")
    private LocalDateTime createdAt;

    @Column(name = "update_at")
    private LocalDateTime updatedAt;


}
