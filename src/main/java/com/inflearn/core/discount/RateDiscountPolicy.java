package com.inflearn.core.discount;

import com.inflearn.core.member.Grade;
import com.inflearn.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {
    private int discountPrice = 10; //10% 할인
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP){
            return price * discountPrice / 100;
        }
        return 0;
    }
}
