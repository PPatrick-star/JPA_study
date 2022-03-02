package kr.study.jpa;

import kr.study.jpa.domain.Case001;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@Slf4j
public class JpaStudyApplication {

    public static void main(String[] args) {
        log.debug("main");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        try {
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            em.persist(Case001.MemberEnt.builder()
                    .id(1L)
                    .build());

            try {
                System.out.println("Hello world");
                transaction.commit();
            }catch (Throwable e) {
                transaction.rollback();
                throw new RuntimeException(e);
            }
        } finally {
            em.close();
            emf.close();
        }
    }
}
