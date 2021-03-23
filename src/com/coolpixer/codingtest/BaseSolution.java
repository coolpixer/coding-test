package com.coolpixer.codingtest;

import java.util.Optional;

public class BaseSolution {
    public static void msg(Object o) {
        msg(o.toString());
    }

    public static void msg(String s) {
        System.out.println(Optional.ofNullable(s).orElse(""));
    }

    public static void msg(String f, Object... args) {
        if(!f.contains("{}")) {
            msg(f);
            return;
        }

        StringBuilder sb = new StringBuilder();
        int s = 0, i = 0, p = 0;
        while((i = f.indexOf("{}", s)) >= 0) {
            if(i > 0) {
                sb.append(f.substring(s, i));
            }
            if(p < args.length) {
                sb.append(args[p++]);
            }
            s = i + 2;
        }
        sb.append(f.substring(s, f.length()));

        msg(sb.toString());
    }
}
