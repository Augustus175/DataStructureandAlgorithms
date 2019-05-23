package com.dsa.mydsa.geettech.chapter01;

import java.util.HashMap;
import java.util.Map;

public class BMpater {
    private Map<Character, Integer> charMap = new HashMap<>();
    private int[] suffix;
    private boolean[] prefix;
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

    private void generateGs(String model) {
        int m = model.length();
        this.suffix = new int[m];
        this.prefix = new boolean[m];
        for (int i = 0; i < m; i++) {
            suffix[i] = -1;
            prefix[i] = false;
        }
        for (int i = 0; i < m - 1; i++) {
            int j = i;
            int k = 0;
            while (j >= 0 && model.charAt(j) == model.charAt(m - 1 - k)) {
                j--;
                k++;
                suffix[k] = j + 1;
            }
            if (j == -1) {
                prefix[i] = true;
            }

        }
    }

    private int match(int index, char badchar) {
        int step = badChar(index, badchar);
        if (suffix[index] > step) {
            return suffix[index];
        }
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
