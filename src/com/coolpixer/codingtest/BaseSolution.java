package com.coolpixer.codingtest;

import java.util.Optional;
import java.util.StringJoiner;

public class BaseSolution {
    static final String ARRAY_DELIMITER = ",";
    static final String ARRAY_PREFIX    = "[";
    static final String ARRAY_SUFFIX    = "]";

    public static void msg(byte b) {
        msg(String.valueOf(b));
    }

    public static void msg(byte[] arr) {
        StringJoiner sj = new StringJoiner(ARRAY_DELIMITER, ARRAY_PREFIX, ARRAY_SUFFIX);
        for(byte x : arr) {
            sj.add(String.valueOf(x));
        }
        msg(sj.toString());
    }

    public static void msg(short s) {
        msg(String.valueOf(s));
    }

    public static void msg(short[] arr) {
        StringJoiner sj = new StringJoiner(ARRAY_DELIMITER, ARRAY_PREFIX, ARRAY_SUFFIX);
        for(short x : arr) {
            sj.add(String.valueOf(x));
        }
        msg(sj.toString());
    }

    public static void msg(int i) {
        msg(String.valueOf(i));
    }

    public static void msg(int[] arr) {
        StringJoiner sj = new StringJoiner(ARRAY_DELIMITER, ARRAY_PREFIX, ARRAY_SUFFIX);
        for(int i : arr) {
            sj.add(String.valueOf(i));
        }
        msg(sj.toString());
    }

    public static void msg(long l) {
        msg(String.valueOf(l));
    }

    public static void msg(long[] arr) {
        StringJoiner sj = new StringJoiner(ARRAY_DELIMITER, ARRAY_PREFIX, ARRAY_SUFFIX);
        for(long x : arr) {
            sj.add(String.valueOf(x));
        }
        msg(sj.toString());
    }

    public static void msg(float f) {
        msg(String.valueOf(f));
    }

    public static void msg(float[] arr) {
        StringJoiner sj = new StringJoiner(ARRAY_DELIMITER, ARRAY_PREFIX, ARRAY_SUFFIX);
        for(float x : arr) {
            sj.add(String.valueOf(x));
        }
        msg(sj.toString());
    }

    public static void msg(double d) {
        msg(String.valueOf(d));
    }

    public static void msg(double[] arr) {
        StringJoiner sj = new StringJoiner(ARRAY_DELIMITER, ARRAY_PREFIX, ARRAY_SUFFIX);
        for(double x : arr) {
            sj.add(String.valueOf(x));
        }
        msg(sj.toString());
    }

    public static void msg(char c) {
        msg(String.valueOf(c));
    }

    public static void msg(char[] arr) {
        StringJoiner sj = new StringJoiner(ARRAY_DELIMITER, ARRAY_PREFIX, ARRAY_SUFFIX);
        for(char x : arr) {
            sj.add(String.valueOf(x));
        }
        msg(sj.toString());
    }

    public static void msg(boolean b) {
        msg(String.valueOf(b));
    }

    public static void msg(boolean[] arr) {
        StringJoiner sj = new StringJoiner(ARRAY_DELIMITER, ARRAY_PREFIX, ARRAY_SUFFIX);
        for(boolean x : arr) {
            sj.add(String.valueOf(x));
        }
        msg(sj.toString());
    }

    public static void msg(Object o) {
        msg(Optional.ofNullable(o).orElse("").toString());
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

    public static<T> void msg(T[] arr) {
        StringJoiner sj = new StringJoiner(ARRAY_DELIMITER, ARRAY_PREFIX, ARRAY_SUFFIX);
        for(T a : arr) {
            sj.add(a.toString());
        }
        msg(sj.toString());
    }

}
