package com.coolpixer.codingtest;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class IncompletionTest {
    private Incompletion incompletion = new Incompletion();

    @Test
    void whenNormalCase1() {
        String[] participant = new String[]{"leo", "kiki", "eden"};
        String[] completion = new String[]{"eden", "kiki"};

        String result = incompletion.solution(participant, completion);
        System.out.println(result);
        assertEquals(result, "leo");
    }

    @Test
    void whenNormalCase2() {
        String[] participant = new String[]{ "marina", "josipa", "nikola", "vinko", "filipa" };
        String[] completion = new String[]{ "marina", "josipa", "nikola", "filipa" };

        String result = incompletion.solution(participant, completion);
        assertEquals(result, "vinko");
    }

    @Test
    void whenNormalCase3() {
        String[] participant = new String[]{ "mislav", "stanko", "mislav", "ana" };
        String[] completion = new String[]{ "stanko", "ana", "mislav" };

        String result = incompletion.solution(participant, completion);
        assertEquals(result, "mislav");
    }
}
