package hellojpa;

import jakarta.persistence.*;
import org.hibernate.Hibernate;

import java.util.List;

public class JpaMain{

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Address address = new Address("city", "street", "zipcode");

            Member member1 = new Member();
            member1.setUsername("meber1");
            member1.setHomeAddress(address);
            em.persist(member1);

            Address newAddress = new Address("NewCity", address.getStreet(), address.getZipcode());
            member1.setHomeAddress(newAddress); // 값 하나만 변경하는 것이 아닌 통으로 바꾸는 것

            tx.commit();
        } catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        }finally {
            em.close();     // 데이터베이스 커넥션 반환
        }
        emf.close();
    }

}
