package com.coolpixer.codingtest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoreSpicyTest {
    MoreSpicy moreSpicy = new MoreSpicy();

    @Test
    void whenImpossibleExpectedMinusOneReturned() {
        int result = moreSpicy.solution(new int[]{1, 2, 3, 9, 10, 12}, 200);
        assertEquals(result, -1);
    }

    @Test
    void whenNormalCase1() {
        int result = moreSpicy.solution(new int[]{1, 2, 3, 9, 10, 12}, 7);
        assertEquals(result, 2);
    }
}