package com.inflearn.core.order;

import com.inflearn.core.discount.DiscountPolicy;
import com.inflearn.core.discount.FixDiscountPolicy;
import com.inflearn.core.discount.RateDiscountPolicy;
import com.inflearn.core.member.Member;
import com.inflearn.core.member.MemberRepository;
import com.inflearn.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member targetMember = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(targetMember, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);

    }
}
