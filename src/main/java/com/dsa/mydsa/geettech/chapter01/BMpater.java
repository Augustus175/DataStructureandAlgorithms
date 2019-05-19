package com.dsa.mydsa.geettech.chapter01;

public class BMpater {
    public int pattern(String text, String modle) {
        int i = 0;
        while (i <= text.length() - modle.length()) {
            int k = i + modle.length() -1;
            int j;
            for (j = modle.length()-1; j >= 0 && text.charAt(k--) == modle.charAt(j); j--);
            if (j < 0) {
                return i;
            } else {
                i += match();
            }
        }
        return -1;
    }

    public int match() {
        return 1;
    }

    public static void main(String[] args) {
        BMpater lMpater = new BMpater();
        int re = lMpater.pattern("string", "og");
        System.out.println(re);
    }
}
