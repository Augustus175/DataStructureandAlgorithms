package com.dsa.mydsa.other;

import java.util.HashSet;
import java.util.Set;

public class PatternString {
    public int myPattern(String str) {
        Set<String> set = new HashSet<>();
        int len = str.length();
        if (len < 3) {
            return 0;
        }
        int i = 0;
        while (i <= len - 3) {
            if ((str.charAt(i) == str.charAt(i + 1) && (str.charAt(i + 1) != str.charAt(i + 2)))) {
                set.add(str.substring(i, 3));
                i += 3;
            } else {
                i++;
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        PatternString patternString = new PatternString();
        String str = "AABTTS";
        str = "aabbc";
        int pattern = patternString.myPattern(str);
        System.out.println(pattern);

    }
}
