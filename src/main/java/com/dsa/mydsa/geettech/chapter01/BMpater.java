package com.dsa.mydsa.geettech.chapter01;

import java.util.HashMap;
import java.util.Map;

public class BMpater {
    private Map<Character, Integer> charMap = new HashMap<>();
    private int[] suffix;
    private int[] mGs;

    public int pattern(String text, String model) {
        int i = 0;
        fillMap(model);
        suffix = new int[model.length()];
        mGs = new int[model.length()];
        while (i <= text.length() - model.length()) {
            int k = i + model.length() - 1;
            int j;
            for (j = model.length() - 1; j >= 0 && text.charAt(k--) == model.charAt(j); j--) ;
            if (j < 0) {
                return i;
            } else {
                i += match(j, text.charAt(k + 1));
            }
        }
        return -1;
    }

    private int match(int index, char badchar) {
        int step = badChar(index, badchar);
        if (step > 0) {
            return step;
        }
        return 1;
    }

    private int badChar(int j, char badchar) {
        if (charMap.containsKey(badchar)) {
            int lastIndex = charMap.get(badchar);
            return j - lastIndex + 1;
        } else {
            return j + 1;
        }
    }

    private void fillMap(String model) {
        int len;
        for (int i = 0; i < (len = model.length()); i++) {
            charMap.put(model.charAt(i), i);
        }
    }

    public static void main(String[] args) {
        BMpater lMpater = new BMpater();
        int re = lMpater.pattern("string", "ing");
        System.out.println(re);
    }
}
