package com.coolpixer.codingtest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhonebookTest {
    Phonebook phonebook = new Phonebook();

    @Test
    @DisplayName("예제1")
    void solution1() {
        assertEquals(phonebook.solution(new String[]{"119", "97674223", "1195524421"}), false);
    }

    @Test
    @DisplayName("예제2")
    void solution2() {
        assertEquals(phonebook.solution(new String[]{"123","456","789"}), true);
    }

    @Test
    @DisplayName("예제3")
    void solution3() {
        assertEquals(phonebook.solution(new String[]{"12","123","1235","567","88"}), false);
    }

}