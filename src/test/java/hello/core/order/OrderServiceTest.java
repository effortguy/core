package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderServiceTest {


    MemberService memberService = new MemberServiceImpl(null);
    OrderService orderService = new OrderServiceImpl(null, null);

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000L);
    }
    
// 생성자의 파라미터 중 하나라도 빈에 등록되어 있지 않으면 에러
//    @Test
//    void getMemberRepositoryBean() {
//        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
//        MemberRepository memberRepositoryBean = ac.getBean(MemberRepository.class);
//
//        System.out.println(memberRepositoryBean);
//    }
}