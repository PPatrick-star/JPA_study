package kr.study.jpa;

import kr.study.jpa.domain.Case001.MemberEnt;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class Case001EntityBasicTest {

    @Test
    public void case_001_builder_01_new_instance() {
        log.debug("case_001_builder_01_new_instance");

        final Long givenId = 1L;
        MemberEnt member = MemberEnt.builder()
                .id(givenId)
                .build();
        assertThat(member).isNotNull()
                .is(new Condition<>(m -> givenId.equals(m.getId()),"expected id"));

    }
}
