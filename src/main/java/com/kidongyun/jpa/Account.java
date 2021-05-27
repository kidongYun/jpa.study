package com.kidongyun.jpa;

import javax.persistence.*;
import java.util.Date;

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
    private String username;

    private String password;

    @Temporal(TemporalType.DATE)
    private Date created = new Date();

    private String yes;

    @Transient
    private String no;

    @Embedded
    private Address homeAddress;

    @Embedded
    private Address officeAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getYes() {
        return yes;
    }

    public void setYes(String yes) {
        this.yes = yes;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }
}
