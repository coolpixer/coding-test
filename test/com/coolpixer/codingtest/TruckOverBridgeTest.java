package com.coolpixer.codingtest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TruckOverBridgeTest {
    TruckOverBridge truckOverBridge = new TruckOverBridge();

    @Test
    void whenNormalCase1() {
        int result = truckOverBridge.solution(2, 10, new int[]{7, 4, 5, 6});
        assertEquals(result, 8);
    }

    @Test
    void whenNormalCase2() {
        int result = truckOverBridge.solution(100, 100, new int[]{10});
        assertEquals(result, 101);
    }

    @Test
    void whenNormalCase3() {
        int result = truckOverBridge.solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10});
        assertEquals(result, 110);
    }
}