package com.dsa.mydsa.NowCoder.offer;

/**
 * Created by zhangzhibo on 17-7-8.
 */
public class No55 {
    public static void main(String[] args) {
        char[] str = "aaa".toCharArray();
        char[] pattern = "ab*ac*a".toCharArray();
        System.out.println(match(str,pattern));
    }
    public static boolean match(char[] str, char[] pattern){
        if (str == null || pattern == null) {
            return false;
        }
        return matchcore(str,0,pattern,0);
    }

    public static boolean matchcore(char[] str, int i, char[] pattern, int j) {
        if (i == str.length  && j == pattern.length ) {
            return true;
        }
        if (i != str.length  && j == pattern.length ) {
            return false;
        }
        if ((j + 1) < pattern.length && pattern[j + 1] == '*') {
            if (i<str.length&&pattern[j] == str[i] || pattern[j] == '.' && i < str.length) {
                return matchcore(str, i, pattern, j + 2) || matchcore(str, i + 1, pattern, j) || matchcore(str, i + 1, pattern, j + 2);
            } else {
                return matchcore(str, i, pattern, j + 2);
            }
        }
        if (i<str.length&&pattern[j] == str[i] || pattern[j] == '.' && i < str.length) {
            return matchcore(str, i + 1, pattern, j + 1);
        }
        return false;
    }
}
