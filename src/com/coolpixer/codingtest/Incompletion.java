package com.coolpixer.codingtest;

import java.util.*;

public class Incompletion {
    private String[] emptyArray() {
        return new String[]{};
    }

    public String solution(String[] participant, String[] completion) {
        // return innerSolution1(participant, completion);
        return innerSolution2(participant, completion);
    }

    private String innerSolution1(String[] participant, String[] completion) {
        ArrayList<String> _participant = new ArrayList<>();
        Arrays.stream(Optional.ofNullable(participant)
                .orElseGet(() -> emptyArray()))
                .forEach(_participant::add);

        Arrays.stream(Optional.ofNullable(completion)
                .orElseGet(() -> emptyArray()))
                .forEach(_participant::remove);

        return _participant.get(0);
    }

    private String innerSolution2(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String s : Optional.ofNullable(participant)
                .orElseGet(() -> emptyArray())) {
            // 아래 5줄은 map.put(s, map.getOrDefault(s, 0) + 1) 로 대체 가능
            if(map.get(s) == null) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s) + 1);
            }
        }
        for(String s : Optional.ofNullable(completion)
                .orElseGet(() -> emptyArray())) {
           map.put(s, map.get(s) - 1);
        }
        for(String s : Optional.ofNullable(participant)
                .orElseGet(() -> emptyArray())) {
            if(map.get(s) == 1) return s;
        }

        return "";
    }
}
