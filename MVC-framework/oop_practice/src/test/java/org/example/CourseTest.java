package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

public class CourseTest {

    @DisplayName("과목(코스)를 생성한다")
    @Test
    void createTest() {
        assertThatCode(() -> new Course("OOP",3,"A+"))
                .doesNotThrowAnyException(); // 해당 코스가 정상적으로 생성된다면 아무런 익셉션을 발생시키지 않는다
    }
}
