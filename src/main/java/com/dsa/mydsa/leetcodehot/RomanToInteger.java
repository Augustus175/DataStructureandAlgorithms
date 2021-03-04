package com.dsa.mydsa.leetcodehot;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        int length = s.length();
        int result = 0;
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        Map<String, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            map.put(romans[i], nums[i]);
        }
        String key;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            key = String.valueOf(c);
            if (c == 'C') {
                if (i + 1 < length && s.charAt(i + 1) == 'M') {
                    key = "CM";
                    i++;
                } else if (i + 1 < length && s.charAt(i + 1) == 'D') {
                    key = "CD";
                    i++;
                }
            }
            if (c == 'X') {
                if (i + 1 < length && s.charAt(i + 1) == 'C') {
                    key = "XC";
                    i++;
                } else if (i + 1 < length && s.charAt(i + 1) == 'L') {
                    key = "XL";
                    i++;
                }
            }
            if (c == 'I') {
                if (i + 1 < length && s.charAt(i + 1) == 'X') {
                    key = "IX";
                    i++;
                } else if (i + 1 < length && s.charAt(i + 1) == 'V') {
                    key = "IV";
                    i++;
                }
            }
            result += map.get(key);
        }
        return result;
    }

    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        String s = "III";
        int i = romanToInteger.romanToInt(s);
        System.out.println(i);
    }
}
