package com.coolpixer.codingtest;

import javax.swing.*;
import java.sql.SQLOutput;
import java.util.*;

import static com.coolpixer.codingtest.CommonUtil.msg;

public class Phonebook {
    public static void main(String[] args) {
        msg((new Phonebook()).solution(new String[]{"119", "97674223", "1195524421"}));
    }

    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book, (o1, o2) -> {
            return Integer.compare(o2.length(), o1.length());
        });

        HashMap<String, Boolean> map = new HashMap<>();
        for(String s : phone_book) {
            if(map.containsKey(s)) {
                return false;
            } else {
                for(int i = 0; i < s.length(); i++) {
                    map.put(s.substring(0, i), true);
                }
            }
        }

        return true;
    }
}
