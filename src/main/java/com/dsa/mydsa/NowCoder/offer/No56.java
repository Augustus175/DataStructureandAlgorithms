package com.dsa.mydsa.NowCoder.offer;

/**
 * Created by zhangzhibo on 17-7-8.
 */
public class No56 {
    public static void main(String[] args) {
//        char[] str = "123.45e+6".toCharArray();
        char[] str = "3.1416".toCharArray();
        String s = "aaa";
        s.matches("aa");
        System.out.println(isNumeric(str));
    }
    public static boolean isNumeric(char[] str) {
        if (str == null) {
            return false;
        }
        int index = 0;
        if (str[index] == '+' || str[index] == '-') {
            index++;
            if (index == str.length) {
                return false;
            }
        }
        boolean isnum = true;
        index = scanNum(str, index);
        if (index != str.length) {
            if (str[index] == '.') {
                index++;
                index = scanNum(str, index);
                if ((index<str.length)&&(str[index] == 'e' || str[index] == 'E')) {
                    isnum = isExpotional(str, index);
                    return isnum;
                }
            } else if ((index<str.length)&&(str[index] == 'e' || str[index] == 'E')) {
                isnum = isExpotional(str, index);
                return isnum;
            } else {
                isnum = false;
            }
        }
        return isnum && (index == str.length);
    }

    public static boolean isExpotional(char[] str, int index) {
        index++;
        if (index == str.length) {
            return false;
        }
        if (str[index] == '+' || str[index] == '-') {
            index++;
        }
        if (index == str.length) {
            return false;
        }
        index = scanNum(str, index);
        return index == str.length ? true : false;
    }

    public static int scanNum(char[] str, int index) {
        while (index != str.length && str[index] >= 48 && str[index] <= 57) {
            index++;
        }
        return index;
    }
}
