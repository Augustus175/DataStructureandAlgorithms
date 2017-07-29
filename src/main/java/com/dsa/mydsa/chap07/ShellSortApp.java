package com.dsa.mydsa.chap07;

/**
 * Created by zhangzhibo on 17-3-30.
 */
class ArraySh {
    static int m;
    private long[] theArray;
    private int nElems;

    public ArraySh(int max) {
        this.theArray = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        theArray[nElems] = value;
        nElems++;
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(theArray[i] + " ");
        }
        System.out.println();
    }

    public void shellSort() {
        int inner, outer;

        int h = 1;
        long temp;
        while (h <= nElems / 3) {
            h = h * 3 + 1;
        }
        h = 7;
        while (h > 0) {
            System.out.println("---------------------------------------------");
            System.out.println(h);
            for (outer = h; outer < nElems; outer++) {
                temp = theArray[outer];
                inner = outer;
                while (inner > h - 1 && theArray[inner - h] >= temp) {
                    theArray[inner] = theArray[inner - h];
                    inner -= h;
                }
                theArray[inner] = temp;
            }//end for
//            for (int i = 0; i < theArray.length; i++) {
//                System.out.print(theArray[i] + " ");
//            }
//            System.out.println();
            h = h - 2;
//            h = (h - 1) / 3;
        }
    }
}


public class ShellSortApp {
    public static void main(String[] args) {
        int maxSize = 22;
        ArraySh arr = new ArraySh(maxSize);
        for (int i = 0; i < maxSize; i++) {
            long n = (int) (java.lang.Math.random() * 99);
            arr.insert(n);
        }
        arr.display();
        arr.shellSort();
        arr.display();
    }
}
