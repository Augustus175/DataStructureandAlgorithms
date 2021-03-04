package com.dsa.mydsa.leetcodehot;

public class ImplementstrStr {
    public int strStr2(String haystack, String needle) {
        if (needle == null || haystack == null || needle.equals(haystack) || needle.equals("")) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        for (int i = 0; i < haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0) && check(haystack, needle, i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean check(String haystack, String needle, int index) {
        index = index + 1;
        int i = 1;
        while (i < needle.length() && index < haystack.length()) {
            if (haystack.charAt(index) == needle.charAt(i)) {
                index++;
                i++;
            } else {
                return false;
            }
        }

        return i == needle.length();
    }

    public int strStr(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();
        for (int start = 0; start < n - L + 1; start++) {
            if (haystack.substring(start, start + L).equals(needle)) {
                return start;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issipi";
        haystack = "mississippi";
        needle = "issipi";
        ImplementstrStr implementstrStr = new ImplementstrStr();
        implementstrStr.strStr(haystack, needle);
    }
}
