package com.example.bookmanager.repository;

import com.example.bookmanager.domain.User;
import net.bytebuddy.TypeCache;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {  //엔티티타입,엔티티에 pk 변수타입
    //queryMethod
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

    Optional<User> findByName(String name);
    List<User> findByEmail(String email); //name으로 찾는다 findBy-- --부분은 Entity필드명 아무거나
    //select * from user where email=?;         결과는 Optional로도 받을 수 있음 findById는 Optional로 받는다 심지어 Set도 가능

    List<User> getByEmail(String email);
    List<User> readByEmail(String email);
    List<User> queryByEmail(String email);
    List<User> searchByEmail(String email);
    List<User> streamByEmail(String email);
    List<User> findUserByEmail(String email);
    List<User> findSomethingByEmail(String emil);
    //SpringData JPA 에서 이상한 문자 다 걸러낸다 Something걸러냄
    //이거 findByEmail이랑 다 똑같은 표현이고 결과도 같다

    //2.First Top
    User findFirstByName(Sort sort, String name);
    List<User> findFirst2ByName(String name);
    //윗대가리에서 두개를 가져온다. findTopByName도 똑같이 사용가능하다 (last는 없음)
    //select * from user where name = ? limit 2;
    //매개변수 Sort를 사용하면 order by 사용가능하다
    //Sort.by(Sort.Derection.DESC,"id");

    //AND OR
    List<User> findByNameAndEmail(String name,String email);
    //select * from user where name=? and email=?;
    List<User> findByNameOrEmail(String name,String email);
    //select * from user where name=? or email?;

    //List<User> findByCreateAtAfter(LocalDateTime yesterday);
    //select * from user where create_at > ?; 이 날짜보다 큰것 즉 지난날이 작은값
    List<User> findByIdAfter(int id);
    //select * from user where id > ?;  매개변수로 받은 값보다 큰 값들

   // List<User> findByCreateAtGreaterThan(LocalDateTime yesterday);
    //select * from user where create_at > ?;
    //List<User> findByCreateAtGreaterThanEqual(LocalDateTime yesterday);
    //select * from user where create_at >= ?;
    //List<User> findByCreateAtBetween(LocalDateTime yesterday,LocalDateTime tomorrow);
    //select * from user where create_at between ? and ?;
    List<User> findByIdBetween(int id1,int id2);
    //select * from user where id between ? and ?;  ?부터 ?까지 ?도포함

    List<User> findByIdGreaterThanAndIdLessThan(int id1,int id2);
    //select * from user where id >? and id<?;
    //between은 자기도 포함한다

   // List<User> findByIdIsNotNull(int id);
    //select * from user where id is not null; null이 아닌 것들만 가져온다
   // List<User> findByIdIsNotEmpty(int id);
    //여기서 not Empty는 Collection이 Empty인지 확인한다
    //필드가 @OneToMany이고 List형태여야 한다 --많이 사용안한다

    List<User> findByNameIn(List<String> names);
    //Iterator가 매개변수로 들아간다
    //select * from user where name in ( ?,?);      --소괄호 안에는 List형태가 들어간다

    List<User> findByNameStartingWith(String name);
    //select * from user where name like ?;
    // --아래 메소드들은 전부 똑같은 쿼리가 작동하고 매개변수로 받는 문자가 앞이냐 뒤냐 포함되느냐에 따라만 다르다
    List<User> findByNameEndingWith(String name);
    List<User> findByNameContains(String name);

    List<User> findByNameLike(String name);
    //위에랑 다른 점은 매개변수를 줄떄 이 메소드는 ("%i%") 이런식으로 준다
    // %는 어디에 오든 상관없다


    List<User> findTop1ByIdOrderByIdDesc(int id);
    //내림차순으로 정렬후 맨 위에 하나만 가지고온다
    //select * from user order by id=? DESC limit 1;
    List<User> findTop1ByNameOrderByIdAsc(String name);


    List<User> findFirstByName(String name,Sort sort);
    //정렬 방법을 매개변수로 받을 수 있다 Sort.by(Sort.Order.desc("id"),Sort.Order.asc("name"));
    //select * from user where name= ? order by id desc,name asc limit 1;


    //Paging
    Page<User> findByName(String name, Pageable pageable);
    //Pageable은 요청값 Page는 응답값으로 보면된다.
    //PageRequest는 Pageable 구현체이고 of메소드는 page,size,sort를 받을 수 있다

    @Query(value="select * from user limit 1;",nativeQuery = true)
    Map<String,Object> findRawRecord(); //위에 쿼리 결과가 Map에 저장되어 리턴된다
}
