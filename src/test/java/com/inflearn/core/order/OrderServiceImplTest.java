package com.inflearn.core.order;

import com.inflearn.core.discount.FixDiscountPolicy;
import com.inflearn.core.member.Grade;
import com.inflearn.core.member.Member;
import com.inflearn.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    /**
     * 생성자 주입이 아닌 수정자 의존관게인 경우
     * memberRepository,discountPolicy 가 모두 의존관계 주입이 누락되어 널포인트예외가 발생
     */
    @Test
    void createOrder() {
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L,"name", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository,new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 1000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}