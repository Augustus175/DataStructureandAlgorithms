package com.dsa.mydsa.NowCoder.offer;

/**
 * Created by Gavin.Stevenson on 2017/7/4.
 */
public class No46 {
    public static void main(String[] args) {
        String str = "I am a student.";
//        String str = "student.";
        System.out.println(ReverseSentence(str));
    }

    public static String ReverseSentence1(String str) {
        if (str.length() == 1 || str.length() == 0) {
            return str;
        }
        String strnew = str.trim();
        String[] strarray = strnew.split(" ");
        overturn1(strarray);
        StringBuilder sb = new StringBuilder();
        for (String s : strarray) {
            sb.append(s);
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    public static void overturn1(String[] strs) {
        int start = 0;
        int end = strs.length - 1;
        while (start < end) {
            String s = strs[start];
            strs[start] = strs[end];
            strs[end] = s;
            start++;
            end--;
        }
    }

    public static String ReverseSentence(String str) {
        if (str == null || str.trim().equals("")) {
            return str;
        }
        char[] strc = str.trim().toCharArray();
        overturn(strc, 0, strc.length - 1);
        int start = 0;
        int end = 0;
        while (end < strc.length && start < strc.length) {
            if (strc[start] == ' ') {
                start++;
                end++;
            } else if (strc[end] == ' ') {
                overturn(strc, start, --end);
                start = ++end;
            } else if (end == strc.length - 1) {
                overturn(strc, start, end);
                break;
            } else {
                end++;
            }
        }
        return new String(strc);

    }

    public static void overturn(char[] c, int start, int end) {
        while (start < end) {
            char t = c[start];
            c[start] = c[end];
            c[end] = t;
            start++;
            end--;
        }
    }
}
