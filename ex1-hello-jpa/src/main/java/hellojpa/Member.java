package hellojpa;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity // JPA를 사용하는 클래스라는 것을 인식
public class Member {
    
    @Id // JPA에게 PK가 뭔지 알려줌
    private Long id;

    @Column(name = "name")  // 객체는 username, DB에는 name
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING)// 객체에서 ENUM 타입을 쓰고 싶을 때
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)   // 날짜,시간 모두 포함
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    private LocalDate testLocalDate;
    private LocalDateTime testLocalDateTime;

    @Lob    // DB에 큰 컨텐츠를 넣고 싶을 때
    private String description;
    
    @Transient  // DB에 추가X, 메모리에서 쓰겠다는 의미
    private int temp;

    public Member() {

    }

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
}
