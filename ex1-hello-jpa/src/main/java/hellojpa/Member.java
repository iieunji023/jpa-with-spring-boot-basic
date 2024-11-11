package hellojpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity // JPA를 사용하는 클래스라는 것을 인식
public class Member {
    
    @Id // JPA에게 PK가 뭔지 알ㄹ려줌
    private Long id;

    @Column(unique = true, length = 10)
    private String name;
    private String email;
    private String phone;

    public Member() {

    }

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

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
