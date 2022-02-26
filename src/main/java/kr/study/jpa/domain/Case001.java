package kr.study.jpa.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

public class Case001 {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Entity
    public static class MemberEnt {
        @Id
        private Long id;

        @Builder
        MemberEnt(Long id) {
            this.id = id;
        }
    }
}
