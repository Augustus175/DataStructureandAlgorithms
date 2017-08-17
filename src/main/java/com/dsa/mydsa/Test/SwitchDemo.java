package com.dsa.mydsa.Test;

/**
 * Created by zhangzhibo on 17-6-4.
 */
public class SwitchDemo {
    public static void main(String[] args) {
        int[] a = {5, 3, 4, 8, 2, 1, 9, 7};
        mergsort(a, 0, a.length - 1);
        for (int i :
                a) {
            System.out.println(i);
        }
    }

    public static int merge(int[] a, int start, int mid, int end) {
        int[] c = new int[end - start + 1];
        int i = mid;
        int j = end;
        int k = c.length - 1;
        int count = 0;
        while (i >= start && j >= mid + 1) {
            if (a[i] > a[j]) {
                c[k--] = a[i--];
                count = count + j - mid;
            } else {
                c[k--] = a[j--];
            }
        }
        while (i >= start) {
            c[k--] = a[i--];
        }
        while (j >= mid + 1) {
            c[k--] = a[j--];
        }
        for (int l = 0; l < c.length; l++) {
            a[l + start] = c[l];
        }
        return count;
    }

    public static int mergsort(int[] a, int start, int end) {
        int count = 0;
        int leftcount = 0;
        int rightcount = 0;
        if (start < end) {
            int mid = (start + end) >> 1;
            leftcount = mergsort(a, start, mid);
            rightcount = mergsort(a, mid + 1, end);
            count = merge(a, start, mid, end);
        }
        return count + leftcount + rightcount;
    }
}
