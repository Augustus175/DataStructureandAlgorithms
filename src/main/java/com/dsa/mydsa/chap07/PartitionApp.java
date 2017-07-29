package com.dsa.mydsa.chap07;

/**
 * Created by Gavin.Stevenson on 2017/4/2.
 */
class ArrayPar {
    private long[] theArray;
    private int nElems;
    private int l = -1;
    private int r = -1;

    public ArrayPar(int max) {
        this.theArray = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        theArray[nElems] = value;
        nElems++;
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            if (i == l || i == r) {
                System.out.print("(" + theArray[i] + ") ");
            } else {
                System.out.print(theArray[i] + " ");
            }
        }
        System.out.println();
    }

    public int partitionIt(int left, int right, long pivot) {
        int leftPtr = left - 1;
        int rightPtr = right + 1;
        while (true) {
            while (leftPtr < right && theArray[++leftPtr] > pivot)
                ;
            while (rightPtr > left && theArray[--rightPtr] < pivot)
                ;
            if (leftPtr >= rightPtr) {
                break;
            } else {
                l = leftPtr;
                r = rightPtr;
                swap(leftPtr, rightPtr);
                display();
            }
        }
        return leftPtr;
    }

    public void swap(int dex1, int dex2) {
        long tmp = theArray[dex1];
        theArray[dex1] = theArray[dex2];
        theArray[dex2] = tmp;
    }

    public int getnElems() {
        return nElems;
    }
}

public class PartitionApp {
    public static void main(String[] args) {
        int maxSize = 11;
        ArrayPar arr = new ArrayPar(maxSize);
        for (int i = 0; i < maxSize; i++) {
            long n = (int) (Math.random() * 199);
            arr.insert(n);
        }
        arr.display();
        long pivot = 99;
        int size = arr.getnElems();
        int partDex = arr.partitionIt(0, size - 1, pivot);
        System.out.println(partDex);
    }
}
