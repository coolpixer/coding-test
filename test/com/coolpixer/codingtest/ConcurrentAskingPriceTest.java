package com.coolpixer.codingtest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ConcurrentAskingPriceTest {
    ConcurrentAskingPrice concurrentAskingPrice = new ConcurrentAskingPrice();

    @Test
    void whenNullExpectedEmptyValueReturned() {
        int[] result = concurrentAskingPrice.solution(null, null);
        assertArrayEquals(result, new int[]{0, 0});
    }

    @Test
    void whenEmptyArrayExpectedEmptyValueReturned() {
        int[] result = concurrentAskingPrice.solution(new Object[][]{}, new Object[][]{});
        assertArrayEquals(result, new int[]{0, 0});
    }

    @Test
    void whenValidInputExpectedValidOutput() {
        Object[][] sell = {
                { "a", 500, 19500 }
                , { "b", 500, 20000 }, { "c", 1000, 20000 }
                , { "d", 2000, 20500 }
                , { "e", 1700, 21000 }
        };

        Object[][] buy = {
                { "A", 500, 20500 }
                , { "B", 700, 21000 }, { "C", 500, 20000 }
                , { "F", 2000, 19500 }, { "E", 1000, 19500 }
                , { "F", 1000, 19000 }
        };
        int[] result = concurrentAskingPrice.solution(sell, buy);
        assertArrayEquals(result, new int[]{20000, 1700});
    }

}