package hellojpa;

import jakarta.persistence.*;

@Entity
public class Member extends BaseEntity{
    
    @Id @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @ManyToOne  // 이렇게 하면 Team 엔티티의 members 필드와 Member 엔티티의 team 필드 모두 연관관계의 주인으로 인식 => 큰일남~!!
    @JoinColumn(name="TEAM_ID", insertable = false, updatable = false)      // 읽기 전용으로 만들어버림(INSERT, UPDATE를 안함)
    private Team team;

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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
