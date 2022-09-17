package hello.hellospring.domain;

import javax.persistence.*;

// JPA는 ORM을 해준다. Object-Relational Mapping, 객체와 관계형데이터베이스의 맵핑.
// Object에 @Entity를 설정해줘야 한다.
@Entity
public class Member {

    // @Id로 primary key를 설정해줘야 한다.
    // 실제 테이블의 PK가 자동 증가 설정인 경우 IDENTITY를 설정해줘야 한다.
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name") // 테이블의 컬럼과 이름이 달라도 맵핑할 수 있음.
    private String name;

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
}
