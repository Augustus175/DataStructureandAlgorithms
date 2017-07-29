package com.dsa.mydsa.NowCoder.offer;

/**
 * Created by zhangzhibo on 17-7-12.
 */
public class No53another {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 4, 8, 2, 6, 7};
        System.out.println(dulpicate(a,a.length));
    }

    public static int dulpicate(int[] number, int length) {
        if (number == null || length == 0) {
            return -1;
        }
        int start = 1;
        int end = length - 1;
        int count = 0;
        int mid = 0;
        while (end >= start) {
            mid = (end + start) >> 1;
            count = countNum(number, start, mid);
            if (end == start) {
                if (count > 1) {
                    return end;
                } else {
                    break;
                }
            }
            if (count > (mid - start + 1)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static int countNum(int[] a, int start, int end) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] >= start && a[i] <= end) {
                count++;
            }
        }
        return count;
    }
}
