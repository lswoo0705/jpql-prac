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
////            String query = "select (select avg(m1.age) from Member m1) as avgAge from Member m left join Team t on m.username = t.name";
//            String query = "select mm.age, mm.username" +
//                    "from (select m.age, m.username from Member m) as mm";
//            List<Member> result = em.createQuery(query, Member.class)
//                    .getResultList();
//
//            System.out.println("result = " + result.size());

            // JPQL 타입 표현식과 기타식
//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("teamA");
//            member.setAge(10);
//            member.setType(MemberType.ADMIN);
//
//            member.setTeam(team);
//
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
////            String query = "select m.username, 'HELLO', true from Member m " +
////                    "where m.type = jpql.MemberType.USER";
////            List<Object[]> result = em.createQuery(query)
////                    .getResultList();
//            String query = "select m.username, 'HELLO', true from Member m " +
//                    "where m.age between 0 and 10";
//            List<Object[]> result = em.createQuery(query)
//                    .setParameter("userType", MemberType.ADMIN)
//                    .getResultList();
//
//            for (Object[] objects : result) {
//                System.out.println("objects = " + objects[0]);
//                System.out.println("objects = " + objects[1]);
//                System.out.println("objects = " + objects[2]);
//            }


            // 조건식(CASE)
//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Member member = new Member();
////            member.setUsername("teamA");
////            member.setUsername(null);
//            member.setUsername("관리자");
//            member.setAge(10);
//            member.setType(MemberType.ADMIN);
//
//            member.setTeam(team);
//
//            em.persist(member);
//
//            em.flush();
//            em.clear();

            // 기본 CASE식
//            String query =
//                    "select " +
//                            "case when m.age <= 10 then '학생요금' " +
//                            "     when m.age >= 60 then '경로요금' " +
//                            "     else '일반요금' " +
//                            "end " +
//                            "from Member m";
            // 조건 CASE식 - COALESCE
//            String query = "select coalesce(m.username, '이름 없는 회원') as username " +
//                    "from Member m ";
//            List<String> result = em.createQuery(query, String.class)
//                    .getResultList();
//
//            for (String s : result) {
//                System.out.println("s = " + s);
//            }
            // 조건 CASE식 - NULLIF - 값이 일치하면 null을 반환
//            String query = "select nullif(m.username, '관리자') as username " +
//                    "from Member m ";
//            List<String> result = em.createQuery(query, String.class)
//                    .getResultList();
//
//            for (String s : result) {
//                System.out.println("s = " + s);
//            }

            // JPQL 함수
//            Team teamA = new Team();
//            teamA.setName("teamA");
//            em.persist(teamA);
//
//            Team teamB = new Team();
//            teamB.setName("teamB");
//            em.persist(teamB);
//
//            Member member1 = new Member();
//            member1.setUsername("관리자1");
//            member1.setAge(10);
//            member1.setType(MemberType.ADMIN);
//            member1.setTeam(teamA);
//            em.persist(member1);
//
//            Member member2 = new Member();
//            member2.setUsername("관리자2");
//            member2.setAge(10);
//            member2.setType(MemberType.ADMIN);
//            member2.setTeam(teamB);
//            em.persist(member2);
//
//            em.flush();
//            em.clear();
//
////            String query = "select concat('a', 'b') from Member m";
////            String query = "select 'a' || 'b' from Member m";
////            String query = "select substring(m.username, 2, 3) from Member m";
////            String query = "select locate('de', 'abcdefg') from Member m";
////            String query = "select size(t.members) from Team t";
////            String query = "select index(t.members) from Team t";
//            String query = "select function('group_concat', m.username) from Member m";
//            List<String> result = em.createQuery(query, String.class)
//                            .getResultList();
//
//            for (String s : result) {
//                System.out.println("s = " + s);
//

            // ===========================================================================
            // 경로 표현식
//            Team teamA = new Team();
//            teamA.setName("teamA");
//            em.persist(teamA);
//
//            Team teamB = new Team();
//            teamB.setName("teamB");
//            em.persist(teamB);
//
//            Member member1 = new Member();
//            member1.setUsername("관리자1");
//            member1.setAge(10);
//            member1.setType(MemberType.ADMIN);
//            member1.setTeam(teamA);
//            em.persist(member1);
//
//            Member member2 = new Member();
//            member2.setUsername("관리자2");
//            member2.setAge(10);
//            member2.setType(MemberType.ADMIN);
//            member2.setTeam(teamB);
//            em.persist(member2);
//
//            em.flush();
//            em.clear();
//
//            String query = "select t.members from Team t";
//            List<Member> result = em.createQuery(query, Member.class)
//                    .getResultList();
//
//            for (Member s : result) {
//                System.out.println("s = " + s);
//            }


            // 페치 조인 - 기본
//            Team teamA = new Team();
//            teamA.setName("팀A");
//            em.persist(teamA);
//
//            Team teamB = new Team();
//            teamB.setName("팀B");
//            em.persist(teamB);
//
//            Member member1 = new Member();
//            member1.setUsername("회원1");
//            member1.setTeam(teamA);
//            em.persist(member1);
//
//            Member member2 = new Member();
//            member2.setUsername("회원2");
//            member2.setTeam(teamA);
//            em.persist(member2);
//
//            Member member3 = new Member();
//            member3.setUsername("회원3");
//            member3.setTeam(teamB);
//            em.persist(member3);
//
//            em.flush();
//            em.clear();
//
////            String query = "select m from Member m";
//            // 회원1, 팀A(SQL)
//            // 회원2, 팀A(1차캐시)
//            // 회원3, 팀B(SQL)
//            // 회원 100명 -> N + 1
//
//            // fetch join으로 해결
////            String query = "select m from Member m join fetch m.team";
//
//            // 컬렉션 페치 조인
//            String query = "select t from Team t join fetch t.members";
//
//            List<Team> result = em.createQuery(query, Team.class)
//                    .getResultList();
//
//            System.out.println("result = " + result.size());
//
//            for (Team team : result) {
//                System.out.println("team = " + team.getName() + " | members = " + team.getMembers().size());
//                for (Member member : team.getMembers()) {
//                    System.out.println("member = " + member);
//                }
//            }

            // Entity를 직접 사용
//            Team teamA = new Team();
//            teamA.setName("팀A");
//            em.persist(teamA);
//
//            Team teamB = new Team();
//            teamB.setName("팀B");
//            em.persist(teamB);
//
//            Member member1 = new Member();
//            member1.setUsername("회원1");
//            member1.setTeam(teamA);
//            em.persist(member1);
//
//            Member member2 = new Member();
//            member2.setUsername("회원2");
//            member2.setTeam(teamA);
//            em.persist(member2);
//
//            Member member3 = new Member();
//            member3.setUsername("회원3");
//            member3.setTeam(teamB);
//            em.persist(member3);
//
//            em.flush();
//            em.clear();
//
//            String query = "select m from Member m where m = :member";
//
//            Member findMember = em.createQuery(query, Member.class)
//                    .setParameter("member", member1)
//                    .getSingleResult();
//
//            System.out.println("findMember = " + findMember);

            // 벌크 연산
            Team teamA = new Team();
            teamA.setName("팀A");
            em.persist(teamA);

            Team teamB = new Team();
            teamB.setName("팀B");
            em.persist(teamB);

            Member member1 = new Member();
            member1.setUsername("회원1");
            member1.setAge(0);
            member1.setTeam(teamA);
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("회원2");
            member2.setAge(0);
            member2.setTeam(teamA);
            em.persist(member2);

            Member member3 = new Member();
            member3.setUsername("회원3");
            member3.setAge(0);
            member3.setTeam(teamB);
            em.persist(member3);

            // flush 자동 호출
            int resultCount = em.createQuery("update Member m set m.age = 20")
                    .executeUpdate();

//            System.out.println("resultCount = " + resultCount);

            // 쿼리문으로 자동 flush가 돼서 DB에는 20살이 적용됐지만, 영속성 컨텍스트에는 clear가 되지않아 0살
//            System.out.println("member1.getAge = " + member1.getAge());
//            System.out.println("member2.getAge = " + member2.getAge());
//            System.out.println("member3.getAge = " + member3.getAge());

            em.clear(); // 벌크 연산 후에 컨텍스트를 초기화
            Member findMember = em.find(Member.class, member1.getId());
            System.out.println("findMember = " + findMember.getAge());

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