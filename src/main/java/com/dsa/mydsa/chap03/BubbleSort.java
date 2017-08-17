package com.dsa.mydsa.chap03;

/**
 * Created by zhangzhibo on 17-3-2.
 * Page 58
 */
class BubbleSort {
    private long[] a;
    private int nElems;

    public BubbleSort(int max) {
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

    public void bubbleSort()
    {
        int out ;
        int in ;
//        定义外层循环
//        有无等号效果是一样的
//        for ( out = nElems-1; out >=1 ; out--) {
        for ( out = nElems-1; out >1 ; out--) {
//            定义内层循环
            for (in = 0; in < out; in++) {
                if(a[in]>a[in+1])
                {
                    long tmp = a[in];
                    a[in] = a[in+1];
                    a[in+1] = tmp;
                }
            }

        }
    }
}
