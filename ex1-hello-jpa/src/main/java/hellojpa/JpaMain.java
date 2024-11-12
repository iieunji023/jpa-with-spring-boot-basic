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

            Member member = new Member();
            member.setId(2L);
            member.setUsername("B");
            member.setRoleType(RoleType.ADMIN);

            em.persist(member);

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        }finally {
            em.close();     // 데이터베이스 커넥션 반환
        }
        emf.close();
    }
}
