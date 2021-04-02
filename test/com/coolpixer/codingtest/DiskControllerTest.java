package com.coolpixer.codingtest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiskControllerTest {

    @Test
    void whenNormalCase1() {
        DiskController diskController = new DiskController();
        int result = diskController.solution(new int[][]{{1, 9}, {2, 6}, {0, 3}});
        assertEquals(result, 9);
    }
}