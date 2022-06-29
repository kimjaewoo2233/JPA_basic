package com.example.bookmanager.domain;


import com.example.bookmanager.repository.UserHistoryRepository;
import com.example.bookmanager.support.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class UserEntityListener {

  //이거 null임 주입을 받지 못한다 그래서 주입할 수 있는 클래스를 만들어야한다
    @PrePersist
    @PreUpdate
    public void prePersistAndpreUpdate(Object obj){ //두가지 애노테이션 사용가능
        UserHistoryRepository userHistoryRepository =
                BeanUtils.getBean(UserHistoryRepository.class);   //Ioc에서 Bean객체 가져온다
        User user = (User)obj;

        UserHistory history = new UserHistory();
        history.setUserId(user.getId());
        history.setName(user.getName());
        history.setEmail(user.getEmail());

        userHistoryRepository.save(history);
    }

}
