package com.dsa.mydsa.NowCoder.offer;

/**
 * Created by zhangzhibo on 17-7-28.
 */
public class textapp {
    public static void main(String[] args) {
        int[] tmp = RandomArray.getArrag(14);
        for (int t :
                tmp) {
            System.out.print(t+" ");
        }
        System.out.println();
        reQuikSort(tmp,0,tmp.length-1);
        for (int t :
                tmp) {
            System.out.print(t+" ");
        }
    }

    public static int partition(int[] a, int left, int right, int key) {
        int leftptr = left - 1;
        int rightptr = right;
        while (true) {
            while (leftptr < right && a[++leftptr] < key) ;
            while (rightptr > left && a[--rightptr] > key) ;
            if (leftptr >= rightptr) {
                break;
            } else {
                swap(a, leftptr, rightptr);
            }
        }
        swap(a, leftptr, right);
        return leftptr;
    }

    public static void swap(int[] a, int l, int r) {
        int tmp = a[l];
        a[l] = a[r];
        a[r] = tmp;
    }

    public static void reQuikSort(int[] a, int left, int right) {
        if (right <= left) {
            return;
        } else {
            int key = a[right];
            int partitionIt = partition(a, left, right, key);
            reQuikSort(a, left, partitionIt - 1);
            reQuikSort(a, partitionIt + 1, right);
        }
    }
}
