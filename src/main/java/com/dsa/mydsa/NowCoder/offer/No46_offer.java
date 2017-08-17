package com.dsa.mydsa.NowCoder.offer;

/**
 * Created by zhangzhibo on 17-8-7.
 */
public class No46_offer {
    public static int getCount(int[] num) {
        int len = num.length;
        int[] counts = new int[len];
        int cou = 0;
        for (int i = len - 1; i >= 0; i--) {
            cou = 0;
            if (i < len - 1) {
                cou = counts[i + 1];
            } else {
                cou = 1;
            }
            if (i < len - 1) {
                if (tobeNum(num, i)) {
                    if (i < len - 2) {
                        cou += (counts[i + 2]);
                    } else {
                        cou += 1;
                    }
                }
            }
            counts[i] = cou;
//            System.out.println(cou);
        }
        return counts[0];
    }

    public static boolean tobeNum(int[] num, int i) {
        if (i < num.length - 1) {
            if ((num[i] * 10 + num[i + 1] < 26) && (num[i] * 10 + num[i + 1] >= 10)) {
                return true;
            }
        }
        return false;
    }
}
