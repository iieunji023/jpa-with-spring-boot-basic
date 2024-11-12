package hellojpa;

import jakarta.persistence.*;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            // 저장
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.setTeam(team);
            em.persist(member);

            em.flush();
            em.clear();

            // 조회
            Member findMember = em.find(Member.class, member.getId());
            Team findTeam = findMember.getTeam();
            System.out.println("findTeam.getName() = " + findTeam.getName());

            Team newTeam = em.find(Team.class, 100L);
            findMember.setTeam(newTeam);

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        }finally {
            em.close();     // 데이터베이스 커넥션 반환
        }
        emf.close();
    }
}
