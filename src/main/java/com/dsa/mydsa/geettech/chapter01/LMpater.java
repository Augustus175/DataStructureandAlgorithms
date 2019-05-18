package com.dsa.mydsa.geettech.chapter01;

public class LMpater {
    public int pattern(String text, String modle) {
        int i = 0;
        while (i < text.length() - modle.length()) {
            int k = i + modle.length();
            int j;
            System.out.println(modle.length());
            for (j = modle.length(); j >= 0 && text.indexOf(k--) == modle.indexOf(j); j--){
                System.out.println("----");
            } ;
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
        LMpater lMpater = new LMpater();
        int re = lMpater.pattern("string", "in");
        System.out.println(re);
    }
}
