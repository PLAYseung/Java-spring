package hello.core.singletone;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingletone() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(testCofig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // ThreadA : A사용자가 10000원 주문
        int userAprice = statefulService1.order("userA", 10000);
        // ThreadA : B사용자가 20000원 주문
        int userBprice = statefulService2.order("userB", 20000);

        // ThreadA : 사용자 A가 주문 금액 조회
//        int price = statefulService1.getPrice();
        System.out.println("price = " + userAprice);

//        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    static class testCofig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}