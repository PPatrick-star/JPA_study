package kr.study.jpa;

import kr.study.jpa.domain.Case001.MemberEnt;
import kr.study.jpa.test.support.EntityManagerSupplier;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManagerFactory;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class Case001EntityBasicTest {

    @Test
    public void case_001_builder_01_new_instance() {
        log.debug("case_001_builder_01_new_instance");

        final Long givenMemberId = 1L;
        final String givenMemberName = "foo";

        EntityManagerFactory emf = EntityManagerSupplier.createEntityManagerFactory();

        MemberEnt member = MemberEnt.builder()
                .memberId(givenMemberId)
                .memberName(givenMemberName)
                .build();

        assertThat(member).isNotNull();
        assertThat(member.getMemberId()).isNotNull().isEqualTo(givenMemberId);
        assertThat(member.getMemberName()).isNotNull().isEqualTo(givenMemberName);

    }
}
