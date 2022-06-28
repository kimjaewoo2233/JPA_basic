package com.example.bookmanager.repository;

import com.example.bookmanager.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@SpringBootTest
public class UserRespositoryTest {

    @Autowired
    private UserRepository userRepository;
    @Test
    public void userTest(){     //crud - create,read,update,delete
            User user = new User();
        LocalDateTime date = LocalDateTime.now();

            user.setName("test");
            user.setEmail("ta3844@naver.com");
            user.setCreateAt(date);
            user.setUpdateAt(date);
            userRepository.save(user);
            userRepository.findAll().forEach(System.out::println);
    }

    @Test
    void crud(){
        List<User> users = userRepository.findAll(Sort.by(Sort.Direction.DESC,"createAt"));
        users.forEach(System.out::println); //findAll은 Sort를 매개변수로 받을 수 있다
        List<User> users2 =  userRepository.findAllById(Lists.newArrayList(1,2,3));
        //assertj는 junit 테스트 코드에서 지원해주는 라이브러리이다. List변수를 선언해서하면 너무 길기에 저렇게하면 자동 add해줌
        //findAllById(List) 이렇게 사용하는 코드임 Id값이 1,2,3인 값을 가져온다는 코드이다
        //sql로 보면 select + from table where id in(1,2,3);
    }
    @Test
    void save(){
        User user1 = new User();
        user1.setName("test");
        user1.setEmail("test2");
        User user2 = new User();
        user2.setName("test");
        user2.setEmail("test2");

        userRepository.saveAll(Lists.newArrayList(user1,user2));    //List타입을 매개변수로 받을 수 있다
        //insert문이 리스트 크기만큼 돈다 결국 이 list크기는 2이기에 insert문이 두번 생긴다
        userRepository.findAll().forEach(System.out::println);
    }
    @Test
    @Transactional
    void outTest(){
        User user = userRepository.getOne(10); //null이면 에러남
        Optional<User> user1 = userRepository.findById(10); //null여도 에러가 안나고 Optional.empty를 리턴한다
        User user2 = userRepository.findById(2).orElse(null);   //이것도 가능  값이 없으면 null을 넣는다는 뜻임
        //findById는 반환값이 Optional이다

        long count = userRepository.count();    //행갯수 그리고 반환타입은 long이어야한다.
        System.out.println(count);
        boolean exists = userRepository.existsById(1);
        System.out.println("값이있으면 true"+exists);
    }
    @Test
    void deleteTest(){
        //delete는 null이 들어가면 문제가 생긴다 delete하기 전에 select를 해서 확인하고 한다
        userRepository.delete(userRepository.findById(1).orElseThrow(RuntimeException::new));
        // userRepository.findById(1).orElseThrow(RuntimeException::new)
        //값이 비면 RuntimeException을 일으키는 코드이다.

        userRepository.deleteById(2);
        userRepository.findAll().forEach(System.out::println);

        //userRepository.deleteAll(); //다지운다
        userRepository.deleteAll(
                userRepository.findAllById(Lists.newArrayList(1,2,3))
        );  //findAllById로 찾은 3개를 지운다 이렇게 찾은 객체를 넣어도 그것들을 지울 수 있음

        userRepository.deleteInBatch(
                userRepository.findAllById(Lists.newArrayList(1,2,3))
        );
        //두개 차이가 있음 이건 delete하기 전에 select를 하지 않는다 있든 없든 바로 delete한다.
        //deleteAllInbatch
    }

    @Test
    void page(){
        //findAll은 매개변수로 Pageable을 받을 수 있다  Pageable은 인터페이스 구현체는 PageRequest
        Page<User> users = userRepository.findAll(PageRequest.of(1,3));     //of(몇쪽(0부터 시작한다),몇개_)
        System.out.println(users);

        System.out.println("totalElements : "+users.getTotalElements());
        System.out.println("totalPages : "+users.getTotalPages());
        System.out.println("numberOfElements : "+users.getNumberOfElements());
        //페이지 사이즈로 엘레멘트를 나눌떄 전체 페이지가 몇쪽인지 보여줌 현재페이지가 몇페이지인지
        System.out.println("sort : "+users.getSort());
        System.out.println("size : "+users.getSize());  //몇개로 나눈지
        users.getContent().forEach(System.out::println);    //내용

    }
    @Test
    void update(){
        //
            User user = new User();
            user.setName("name");
            user.setEmail("ta3333");

            userRepository.save(user);
            User user1  = userRepository.findById(4).orElseThrow(RuntimeException::new);
            userRepository.save(user1);
            //이미있는 값이면 update쿼리가 발생한다 없는 값이면 insert 쿼리가 동작한다
            //Entity객체에서 지정한 @Id값이 null이면 insert 있는 값이면 update한다

    }
    @Test
    void test06(){
        //userRepository.findFirst2ByName("kim").forEach(System.out::print);
       // userRepository.findByCreateAtAfter(LocalDateTime.now().minusDays(1L)).forEach(System.out::println);
       // userRepository.findByIdAfter(3).forEach(System.out::println);
        //   userRepository.findByCreateAtGreaterThanEqual(LocalDateTime.now().minusDays(1L)).forEach(System.out::println);
       // userRepository.findByCreateAtBetween(LocalDateTime.now().minusDays(1L),LocalDateTime.now()).forEach(System.out::println);
       // Optional<User> user = userRepository.findByIdBetween(3,5).stream().findFirst();
       // System.out.println("user========>"+user.get());
       // userRepository.findByIdGreaterThanAndIdLessThan(1,2).forEach(System.out::println);
        //userRepository.findByNameIn(Lists.newArrayList("kim","pa")).forEach(System.out::println);

        System.out.println("findByNameStartingWith"+userRepository.findByNameStartingWith("ki"));
        System.out.println("findByNameContains"+userRepository.findByNameContains("i"));
        System.out.println("findByNameEndingWith"+userRepository.findByNameEndingWith("m"));

    }

}


