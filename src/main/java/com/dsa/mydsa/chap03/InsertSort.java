package com.dsa.mydsa.chap03;

/**
 * Created by zhangzhibo on 17-3-2.
 * Page 70
 */
class InsertSort {
    private long[] a;
    private int nElems;

    public InsertSort(int max) {
        a = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }

    public void display() {
        for (int i = 0; i < nElems - 1; i++) {
            System.out.print(a[i] + " ");

        }
        System.out.println(a[nElems - 1]);
    }

    public void insertSort()
    {
        int out ;
        int in ;
        for ( out = 1; out < nElems; out++) {
            in = out;
            long tmp  = a[out];
//            a[in-1]>tmp是为了比较tmp和左侧有序队中每一个的大小，若是tmp比左侧队中的一个小，就把有序队每一个向后移动一个
            while (in > 0&&a[in-1]>tmp )
            {
                a[in] = a[in-1];
                in--;
            }
            a[in] = tmp;

        }
    }
}
