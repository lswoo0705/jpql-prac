package jpql;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member = new Member();
            member.setUsername("member1");
            member.setAge(10);
            em.persist(member);

            // 반환 타입이 명확할 때
//            TypedQuery<Member> query1 = em.createQuery("select m from Member m", Member.class);
//            TypedQuery<String> query2 = em.createQuery("select m.username from Member m", String.class);
            // 반환 타입이 명확하지 않을 때
//            Query query3 = em.createQuery("select m.username, m.age from Member m");

            // 결과 값이 여러개일 때
//            TypedQuery<Member> query1 = em.createQuery("select m from Member m", Member.class);
//            List<Member> resultList = query1.getResultList();
//            for (Member member1 : resultList) {
//                System.out.println("member1 = " + member1);
//            }
            // 결과가 없으면 빈 리스트 반환

            // 결과 값이 하나일 때
//            TypedQuery<Member> query2 = em.createQuery("select m from Member m.id = 10", Member.class);
//            Member result = query2.getSingleResult();
//            System.out.println("result = " + result);
            // 결과가 없으면 -> NoResultException
            // 결과가 둘 이상이면 -> NonUniqueResultException

            // 파라미터 바인딩
            Member result = em.createQuery("select m from Member m where m.username = :username", Member.class)
                    .setParameter("username", "member1")
                    .getSingleResult();
            System.out.println("result = " + result.getUsername());

            tx.commit(); // 변경 내용을 db에 반영(플러시) -> 이 때 쿼리가 날아감
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
    }
}