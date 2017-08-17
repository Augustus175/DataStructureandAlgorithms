package com.dsa.mydsa.NowCoder.offer;

/**
 * Created by zhangzhibo on 17-7-28.
 */
public class MergeSortText {
    public static void main(String[] args) {
        int[] test = RandomArray.getArrag(10);

        for (int tmp :
                test) {
            System.out.print(tmp+" ");
        }
        System.out.println();
        mergeSort(test,0,test.length-1);
        for (int tmp :
                test) {
            System.out.print(tmp+" ");
        }
    }

    public void merge(int[] a, int[] b, int[] c) {
        int i = 0;
        int k = 0;
        int j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = b[j++];
            }
        }
        while (i < a.length) {
            c[k++] = a[i++];
        }
        while (j < b.length) {
            c[k++] = b[j++];
        }
    }

    public static void merge(int[] a, int first, int mid, int last) {
        int i = first;
        int j = mid + 1;
        int k = 0;
        int[] c = new int[last - first + 1];
        while (i <= mid && j <= last) {
            if (a[i] < a[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = a[j++];
            }
        }
        while (i <= mid) {
            c[k++] = a[i++];
        }
        while (j <= last) {
            c[k++] = a[j++];
        }
        for (int l = 0; l < c.length; l++) {
            a[l + first] = c[l];
        }
    }

    public static void mergeSort(int[] a, int first, int last) {
        if (first < last) {
            int mid = (first + last) / 2;
            mergeSort(a, first, mid);
            mergeSort(a, mid + 1, last);
            merge(a, first, mid, last);
        }
    }
}
