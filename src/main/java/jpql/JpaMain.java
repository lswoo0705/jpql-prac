package jpql;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setAge(10);
//            em.persist(member);

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
//            Member result = em.createQuery("select m from Member m where m.username = :username", Member.class)
//                    .setParameter("username", "member1")
//                    .getSingleResult();
//            System.out.println("result = " + result.getUsername());


            // 프로젝션(SELECT)
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setAge(10);
//            em.persist(member);
//
//            em.flush();
//            em.clear();

//            List<Member> result = em.createQuery("select m from Member m", Member.class)
//                    .getResultList();
//
//            Member findmember = result.get(0);
//            findmember.setAge(20);

//            List<Team> result = em.createQuery("select t from Member m join m.team t", Team.class)
//                    .getResultList();

//            em.createQuery("select o.address from Order o", Address.class)
//                    .getResultList();

//            em.createQuery("select m.username, m.age from Member m")
//                    .getResultList();

//            List resultList = em.createQuery("select m.username, m.age from Member m")
//                    .getResultList();
//
//            Object o = resultList.get(0);
//            Object[] result = (Object[]) o;
//            System.out.println("name = " + result[0]);
//            System.out.println("age = " + result[1]);

//            List<Object[]> resultList = em.createQuery("select m.username, m.age from Member m")
//                    .getResultList();
//
//            Object[] result = resultList.get(0);
//            System.out.println("name = " + result[0]);
//            System.out.println("age = " + result[1]);

//            List<MemberDTO> result = em.createQuery("select new jpql.MemberDTO(m.username, m.age) from Member m", MemberDTO.class)
//                    .getResultList();
//
//            MemberDTO memberDTO = result.get(0);
//            System.out.println("memberDTO.username = " + memberDTO.getUsername());
//            System.out.println("memberDTO.age = " + memberDTO.getAge());


            // 페이징
//            for (int i = 0; i < 100; i++) {
//                Member member = new Member();
//                member.setUsername("member1" + i);
//                member.setAge(i);
//                em.persist(member);
//            }
//
//            em.flush();
//            em.clear();
//
//            List<Member> result = em.createQuery("select m from Member m order by m.age desc", Member.class)
//                    .setFirstResult(0)
//                    .setMaxResults(10)
//                    .getResultList();
//
//            System.out.println("result.size = " + result.size());
//            for (Member member1 : result) {
//                System.out.println("member1 = " + member1);
//            }

            // 조인
//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("teamA");
//            member.setAge(10);
//
//            member.setTeam(team);
//
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
////            String query = "select m from Member m inner join m.team t"; // 내부 조인
////            String query = "select m from Member m left join m.team t"; // 외부 조인(left = left outer)
////            String query = "select m from Member m, Team t where m.username = t.name"; // 세타 조인
////            String query = "select m from Member m left join m.team t on t.name = 'teamA'"; // 조인 대상 필터링
//            String query = "select m from Member m left join Team t on m.username = t.name"; // 연관관계 없는 엔티티 외부 조인
//            List<Member> result = em.createQuery(query, Member.class)
//                    .getResultList();
//
//            System.out.println("result = " + result.size());


            // 서브 쿼리
            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("teamA");
            member.setAge(10);

            member.setTeam(team);

            em.persist(member);

            em.flush();
            em.clear();

//            String query = "select (select avg(m1.age) from Member m1) as avgAge from Member m left join Team t on m.username = t.name";
            String query = "select mm.age, mm.username" +
                    "from (select m.age, m.username from Member m) as mm";
            List<Member> result = em.createQuery(query, Member.class)
                    .getResultList();

            System.out.println("result = " + result.size());

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