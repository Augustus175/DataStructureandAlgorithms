package com.dsa.mydsa.chap01b;

/**
 * Created by zhangzhibo on 2017/5/11.
 */
public class ManacherApp {
    public static void main(String[] args) {
//        String str = "abcdefg";
        String str = "12212321";
        char[] extendstr = new char[2 * str.length() + 2];
        int j = 0;
        extendstr[0] = '$';
        for (int i = 1; i < extendstr.length; i++) {
            if (i % 2 != 0) {
                extendstr[i] = '#';
            } else {
                extendstr[i] = str.charAt(j);
                j++;
            }
        }
//        for (char c : extendstr) {
//            System.out.print(c);
//        }
        int[] p = new int[extendstr.length];
        Manacher(extendstr, p);
        for (int k : p) {
            System.out.print(k + " ");
        }
    }

    public static void Manacher(char[] extendstr, int[] p) {
        int size = extendstr.length;
        p[0] = 1;
        int id = 0;
        int max = 1;
        for (int i = 1; i < size; i++) {
            if (max > 1) {
                p[i] = Math.min(p[2 * id - i], max - i);
            } else {
                p[i] = 1;
            }

            while(i+p[i]<size)
            {
                if (extendstr[i + p[i]] == extendstr[i - p[i]])
                {
                    p[i]++;
                }else{
                    break;
                }
            }
            if (max < i + p[i]) {
                max = i + p[i];
                id = i;
            }
        }

    }
}
