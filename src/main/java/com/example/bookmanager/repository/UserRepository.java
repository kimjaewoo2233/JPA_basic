package com.example.bookmanager.repository;

import com.example.bookmanager.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {  //엔티티타입,엔티티에 pk 변수타입
    // JpaRepository 인터페이스에 구현체는 SimpleJpaRepository에 구현되어있다
    //findAll()     --데이터 양이 많을떄 사용 ㄴㄴ
    //findAll(Sort sort) -- 정렬값
    //findAll(iterable<ID> ids);    --iterable은 List
    //<S extends T> saveAll(Iterable<S> entities);     --T는 User타입
    //flush()   --현재 jpacontext 가 가진 값을 db에 반영하는 메소드
    //saveAndFlush()    --저장한 값을 JPAContext가 가지고 있지 말고 바로 DB에 저장하는 메소드
    //deleteInBatch(Iterable<T> entities)   --List타입으로 받아 한번에 다지운다
    //deleteAllInBatch()  -- 조건 없이 해당 테이블 값을 모두지운다.  쓸일없음
    //T getOne(ID id);      --여기서 ID는 Long타입이다
    //<S extends T> List<S> findAll(Example<S> example,Sort sort);  --example 값을 사용할 수도 있따
    //<S extends T> List<S> findAll(Example<S> example);
    //여기서부터는 JpaRepositry가 상속받은 crudRepository 메소드이다
    //<S extends T> S save(S entitiy);
    //<S extends T> Iterable<S> saveAll(Iterable<S> entities);
    //Optional<T> findById(ID id);
    //boolean existsById(ID id);    //해당객체가 존재하는지
    //long count()   갯수

}
