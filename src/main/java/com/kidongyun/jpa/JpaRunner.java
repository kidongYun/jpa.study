package com.kidongyun.jpa;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/*
    @Transactional : 이 클래스 내에 존재하는 메소드들이 각각 하나의 트랜잭션임을 명시한다
 */
@Transactional
@Component
public class JpaRunner implements ApplicationRunner {

    /*
        EntityManager 객체는 JPA 에서 굉장히 중요한 객체
     */
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = new Account();
        account.setName("keesun");
        account.setPassword("jpa");

        /*
            여기서 persist() 함수는 바로 저장소를 향해 데이터 영속화 작업을 진행하지는 않는다.
            JPA 는 Persistence Context 라는 영속화 컨텍스트 영역을 제공하는데 여기서 캐시의 기능을 제공한다.
            persist() 함수는 이 캐시 공간에 데이터 영속화 작업을 하고, 트랜잭션이 끝나게되면 그 시점에 실제 저장소로 데이터를 영속화 한다.
         */
        entityManager.persist(account);

        /*
            JPA 에서 제공하는 EntityManager 내부적으로는 Session 객체가 사용되는데 이 객체는 Hibernate 에서 제공되어진 것이다.
            아래 코드는 Hibernate 에서 제공한 Session 객체를 활용해서 위와 persist() 함수와 동일한 기능을 하도록 구현한 것이다.
         */
        Session session = entityManager.unwrap(Session.class);
        session.save(account);
    }
}
