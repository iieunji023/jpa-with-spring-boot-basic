package hellojpa;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {
    
    @Id @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @ManyToOne  // 이렇게 하면 Team 엔티티의 members 필드와 Member 엔티티의 team 필드 모두 연관관계의 주인으로 인식 => 큰일남~!!
    @JoinColumn(name="TEAM_ID", insertable = false, updatable = false)      // 읽기 전용으로 만들어버림(INSERT, UPDATE를 안함)
    private Team team;

    @OneToOne
    @JoinColumn(name="LOCKER_ID")
    private Locker locker;

//    @ManyToMany
//    @JoinTable(name = "MEMBER_PRODUCT")
    @OneToMany(mappedBy = "member")
    private List<MemberProduct> memberProducts = new ArrayList<>();

//    @Column(name="TEAM_ID")
//    private Long  teamId;
//    @ManyToOne // Member와 Team 객체의 관계를 JPA에게 알려주기, 1개의 팀에 여러 멤버가 있으니까 팀이 1, 멤바가 N
//    @JoinColumn(name="TEAM_ID") // 테이블 연관관계의 FK와 연결시켜주기
//    private Team team;

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

//    public Team getTeam() {
//        return team;
//    }
//
//    public void setTeam(Team team) {
//        this.team = team;
//        team.getMembers().add(this);    // this => 현재 나 자신 (Member)
//    }

//    @Override
//    public String toString() {
//        return "Member{" +
//                "id=" + id +
//                ", username='" + username + '\'' +
//                ", team=" + team +
//                '}';
//    }
}
