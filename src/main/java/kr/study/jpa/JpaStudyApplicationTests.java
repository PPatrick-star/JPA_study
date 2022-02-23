package kr.study.jpa;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class JpaStudyApplicationTests {

    @Test
    public void static_001_main_01_normal() {
        log.debug("static_001_main_01_normal");
        JpaStudyApplication.main(new String[]{});
    }
}
