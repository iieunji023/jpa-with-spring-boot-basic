package hellojpa;

import jakarta.persistence.*;

@Entity

public class Member {
    
    @Id @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

//    @Column(name="TEAM_ID")
//    private Long  teamId;
    @ManyToOne // Member와 Team 객체의 관계를 JPA에게 알려주기, 1개의 팀에 여러 멤버가 있으니까 팀이 1, 멤바가 N
    @JoinColumn(name="TEAM_ID") // 테이블 연관관계의 FK와 연결시켜주기
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
