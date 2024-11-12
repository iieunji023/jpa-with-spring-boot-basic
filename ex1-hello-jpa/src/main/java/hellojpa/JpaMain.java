package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            // 저장
            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
//            member.setTeam(team);
            em.persist(member);

//            team.getMembers().add(member);
            team.addMember(member);

            em.flush();
            em.clear();

            Team findTeam = em.find(Team.class, team.getId());  // 1차 캐시
            List<Member> members = findTeam.getMembers();       // 컬렉션에 아무것도 존재하지 않음, 순수한 객체 상태

            System.out.println("=======================");
            System.out.println("members = " + findTeam);
            System.out.println("=======================");

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        }finally {
            em.close();     // 데이터베이스 커넥션 반환
        }
        emf.close();
    }
}
