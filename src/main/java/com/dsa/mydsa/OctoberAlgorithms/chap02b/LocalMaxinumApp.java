package com.dsa.mydsa.OctoberAlgorithms.chap02b;


/**
 * Created by zhangzhibo on 17-5-25.
 */
public class LocalMaxinumApp {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 3, 3, 5, 4, 6, 1, 2, 1, 5, 8, 9, 4, 1, 2, 1};
        int index = LoaclMaxinum(a);
        System.out.println(a[index]);
    }

    public static int LoaclMaxinum(int[] a) {
        int left = 0;
        int right = a.length - 1;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            System.out.println("the mid is : "+mid);
            if (a[mid] > a[mid + 1]) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }

}
