package com.coolpixer.codingtest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(JUnitPlatform.class)
class BinaryGapTest {
    private BinaryGap binaryGap;

    public BinaryGapTest() {
        binaryGap = getBinaryGap();
    }

    @BeforeAll
    static void setup() {
    }

    @BeforeEach
    void init() {
    }

    BinaryGap getBinaryGap() {
        return new BinaryGap();
    }

    @Test()
    void whenNegativeValueExpectedExceptionThrown() {
        Exception exception = assertThrows(Exception.class, () -> {
            binaryGap.solution(-1);
        });

        String expectedMessage = "invalid parameter";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void whenExpectedZeroReturned() throws Exception {
        int result = 0;

        result = binaryGap.solution(0b0000_0000_0000_0001);
        assertEquals(result, 0);

        result = binaryGap.solution(0b1000_0000_0000_0000);
        assertEquals(result, 0);
    }

    @Test
    void whenExpectedPositiveValueReturned() throws Exception {
        int result = 0;

        result = binaryGap.solution(0b1000_0000_0000_0010);
        assertEquals(result, 13);

        result = binaryGap.solution(0b1000_1000_0010_0010);
        assertEquals(result, 5);
    }

}