package com.dsa.mydsa.NowCoder.offer;

/**
 * Created by zhangzhibo on 17-6-27.
 */
public class No31 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2, 4, 2, 5, 2, 3};
        System.out.println(MoreThanHalfNum_Solution(a));
        int b[] = { 8, 8, 1, 1, 1, 8, 1, 1, 6, 1, 8 };
        MoreThanHalfNum_Solution(b);
        int[] c ={1,2,3,2,4};
        MoreThanHalfNum_Solution(c);
    }

    public static int MoreThanHalfNum_Solution(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int count = 0;
        int m = array[0];
        for (int i = 0; i < array.length; i++) {
            if (count == 0) {
                m = array[i];
                count = 1;
            } else if (m != array[i]) {
                count--;
            } else {
                count++;
            }
        }
        count = 0;
        System.out.println(m);
        for (int i = 0; i < array.length; i++) {
            if (m == array[i]) {
                count++;
            }
        }
        if (count > array.length / 2) {
            return m;
        }
        return 0;
    }
}
