package com.coolpixer.codingtest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockPriceTest {
    StockPrice stockPrice = new StockPrice();

    @Test
    void whenNormalCase1() {
        int[] result = stockPrice.solution(new int[]{1, 2, 3, 2, 3});

        assertArrayEquals(result, new int[]{4, 3, 1, 1, 0});
    }

    @Test
    void whenNormalCase2() {
        int[] result = stockPrice.solution(new int[]{1, 2, 3, 2, 3, 1});

        assertArrayEquals(result, new int[]{5, 4, 1, 2, 1, 0});
    }
}