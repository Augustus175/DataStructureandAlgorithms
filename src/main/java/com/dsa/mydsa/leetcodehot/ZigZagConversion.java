package com.dsa.mydsa.leetcodehot;

class ZigZagConversion {
    public String convert(String s, int numRows) {
        int length = s.length();
        if (length <= 1 || numRows == 1 || length <= numRows) {
            return s;
        }
        if (numRows == 2) {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < length; i++) {
                if (i % 2 == 0) {
                    sb2.append(s.charAt(i));
                } else {
                    sb1.append(s.charAt(i));
                }
            }
            sb2.append(sb1);
            return sb2.toString();
        }
        int n = length / (2 * numRows - 2);
        int l = 0;
        if (n == 0) {
            l++;
        } else {
            l = n * (numRows - 1);
        }
        int ls = length % (2 * numRows - 2);
        if ((ls - numRows) > 0) {
            l = l + 1 + (ls - numRows);
        } else {
            l++;
        }
        char[][] max = new char[numRows][l];
        int k = 0;
        for (int j = 0; j < length && k < length; j++) {
            if (j % (numRows - 1) == 0) {
                for (int i = 0; i < numRows && k < length; i++) {
                    max[i][j] = s.charAt(k++);
                }
            } else {
                int i = (numRows - 1) - j % (numRows - 1);
                max[i][j] = s.charAt(k++);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < l; j++) {
                if (max[i][j] != '\0') {
                    sb.append(max[i][j]);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ZigZagConversion zigZagConversion = new ZigZagConversion();
        String s = "PAYPALISHIRING";
        s = "ABCDE";
        s = "PAYPALISHIRING";
        String convertStr = zigZagConversion.convert(s, 5);
        System.out.println(convertStr);

    }
}
