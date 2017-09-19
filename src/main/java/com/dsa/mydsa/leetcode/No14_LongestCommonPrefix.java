package com.dsa.mydsa.leetcode;

public class No14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuffer sb = new StringBuffer();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if (min > strs[i].length()) {
                min = strs[i].length();
            }
        }
        if (min == 0 || strs.length == 0) {
            return "";
        }
        char c;
        for (int i = 0; i < min; i++) {
            c = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (c != strs[j].charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
