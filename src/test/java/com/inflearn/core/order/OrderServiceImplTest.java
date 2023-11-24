package com.inflearn.core.order;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    /**
     * 생성자 주입이 아닌 수정자 의존관게인 경우
     * memberRepository,discountPolicy 가 모두 의존관계 주입이 누락되어 널포인트예외가 발생
     */
    @Test
    void createOrder() {
        OrderServiceImpl orderService = new OrderServiceImpl();
        orderService.createOrder(1L, "itemA", 1000);
    }

}