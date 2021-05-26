package com.kidongyun.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*
 * @Entity : JPA를 활용하여 Relation 에 매핑되어질 도메인임을 명시
 */
@Entity
public class Account {
    /*
    * @Id : id 값을 PK 로서 사용하겠다는 의미
    * @GeneratedValue : PK 값 생성시에 규칙을 규명할 수 있다.
    */
    @Id
    @GeneratedValue
    private Long id;

    /*
    * @Column : 생략되어질 수 있고, @Entity 안에 존재하는 필드들은 기본적으로 모두 이 어노테이션을 소유한다.
     */
    private String name;

    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
