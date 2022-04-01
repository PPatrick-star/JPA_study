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
        private Long memberId;
        private String memberName;

        @Builder
        MemberEnt(Long memberId, String memberName) {
            this.memberId = memberId;
            this.memberName = memberName;
        }


        /**
         * 회원의 이름을 변경합니다
         * @param memberName - 변경할 새이름을 지정합니다
         * @see //velog.io/@aidenshin/내가-생각하는-JPA-엔티티-작성-원칙
         */
        public void rename (String memberName) {
            this.memberName = memberName;
        }
    }
}
