package kr.study.jpa;

import kr.study.jpa.domain.Case001.MemberEnt;
import kr.study.jpa.test.support.EntityManagerSupplier;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class Case001EntityBasicTest {

    @Test
    public void case_001_builder_01_new_instance() {
        log.debug("case_001_builder_01_new_instance");

        final Long givenMemberId = 1L;
        final String givenMemberName = "foo";

        EntityManagerFactory emf = EntityManagerSupplier.createEntityManagerFactory();

        EntityManager em = emf.createEntityManager();

        MemberEnt member;

        try {

            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            try {
                member = MemberEnt.builder()
                        .memberId(givenMemberId)
                        .memberName(givenMemberName)
                        .build();
                em.persist(member);
                log.debug("persist a new member");
                transaction.commit();

            } catch (Throwable th ) {
                transaction.rollback();
                throw new RuntimeException(th);
            }
        } finally {
            em.close();
        }


        assertThat(member).isNotNull();
        assertThat(member.getMemberId()).isNotNull().isEqualTo(givenMemberId);
        assertThat(member.getMemberName()).isNotNull().isEqualTo(givenMemberName);

    }
}
