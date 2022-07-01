package com.example.bookmanager.domain.listener;

import com.example.bookmanager.domain.Auditable;
import com.example.bookmanager.domain.BaseEntity;
import org.springframework.stereotype.Component;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public class MyEntityListener {

    @PrePersist         //Entity클래스 안에서 사용하는 Listener클래스면 매개변수가 필요없지만 따로 클래스를 만들면 Object 매개변수가 필요하다
    public void prePersist(Object obj){ //실행되는 Entitiy를 매개밴수로 받는다
        if(obj instanceof BaseEntity){       //obj는 Object이므로 형변환필요하다
            ((Auditable)obj).setCreatedAt(LocalDateTime.now());
            ((Auditable)obj).setUpdatedAt(LocalDateTime.now());
        }


    }

    @PreUpdate
    public void preUpdate(Object obj){
        if(obj instanceof BaseEntity){
            ((Auditable)obj).setUpdatedAt(LocalDateTime.now());
        }
    }
}
