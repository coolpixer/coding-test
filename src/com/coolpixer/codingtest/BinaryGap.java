package com.coolpixer.codingtest;

public class BinaryGap {
    public int solution(int N) throws Exception {
        if(N < 1)   throw new Exception("invalid parameter");

        String s = "";
        int r = 0, check = 0, count = 0, maxCount = 0;
        while(true) {
            r = N % 2;
            s = s.concat(String.valueOf(r));

            N = N / 2;
            check += r;
            if(check == 0)   continue;

            count++;
            if(check == 2) {
                maxCount = (maxCount < count - 2) ? count - 2 : maxCount;
                check = 1;
                count = 1;
            }

            if(N == 0)  break;
        }

        // msg(s);

        return maxCount;
    }
}
