package com.example.bookmanager.service;


import com.example.bookmanager.domain.Gender;
import com.example.bookmanager.domain.User;
import com.example.bookmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
public class UserService {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    UserRepository userRepository;
    @Transactional
    public void put(){
        User user = new User();
        user.setName("newUser");
        user.setEmail("test3@naver.com");
        user.setGender(Gender.MALE);

        entityManager.persist(user);

        entityManager.detach(user);     //준영속상태로 만든다 영속성컨텍스트에서 뺴버린다.
        user.setName("PersistedName");

        entityManager.merge(user);      //다시 넣어버린다.
        entityManager.flush();  //변경내용을 모두 반영
        entityManager.clear();  //이것도 (전부)준영속상태로 만드는 것이다. 그렇기 떄문에 db에 반영이 되지 않는다.
        User user1 = userRepository.findById(5L).get();
        entityManager.remove(user1);
    }

}


