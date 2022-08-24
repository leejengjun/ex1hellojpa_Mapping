package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
//
//            // 저장
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setTeam(team);   //**
//            em.persist(member);
//
//        //    team.getMembers().add(member);  //**  Member 클래스의 연관관계 편의 메소드를 생성
//
//            // 영속성 컨텍스트에서가 아닌 DB에 쿼리문을 확인하고 싶을 때
//            em.flush();
//            em.clear();
//            // 영속성 컨텍스트 초기화.
//
//            Team findTeam = em.find(Team.class, team.getId());
//            List<Member> members = findTeam.getMembers();
//
//            for (Member m : members) {
//                System.out.println("m = " + m.getUsername());
//            }

            Member member = new Member();
            member.setUsername("member1");

            em.persist(member);

            Team team = new Team();
            team.setName("teamA");
            team.getMembers().add(member);

            // 위 50-52라인 실행 후 실행되는 쿼리문.
//            Hibernate:
//            /* create one-to-many row hellojpa.Team.members */ update
//                    Member        일대다 단방향에서 '다' 쪽에 있는 Member 테이블에 업데이트문이 실행된다. 왜냐? 테이블 일대다 관계는 항상 다(N) 쪽에 외래 키가 있다.
//            set
//            TEAM_ID=?
//            where
//            MEMBER_ID=?

            em.persist(team);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
