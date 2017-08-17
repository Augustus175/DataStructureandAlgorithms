package com.dsa.mydsa.chap07;

/**
 * Created by Gavin.Stevenson on 2017/4/2.
 */
class ArrayIns {
    private long[] theArray;
    private int nElems;

    public ArrayIns(int max) {
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

    public void quickSort() {
        recQuickSort(0, nElems-1);
    }

    public void recQuickSort(int left, int right) {
        if (right - left <= 0) {
            return;
        } else {
            long pivot = theArray[right];
            int partition = partitionIt(left, right, pivot);
            recQuickSort(left,partition-1);
            recQuickSort(partition+1,right);
        }

    }

    public int partitionIt(int left, int right, long pivot) {
        int leftPtr = left - 1;
        int rightPtr = right;
        while (true) {
            while (theArray[++leftPtr] < pivot)
                ;
            while (rightPtr > 0 && theArray[--rightPtr] > pivot)
                ;
            if (leftPtr >= rightPtr) {
                break;
            } else {
                swap(leftPtr, rightPtr);
            }
        }
        swap(leftPtr, right);
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

public class QuickSort1App {
    public static void main(String[] args) {
        int maxSize = 16;
        ArrayIns arr = new ArrayIns(maxSize);
        for (int i = 0; i < maxSize; i++) {
            long n = (int) (Math.random() * 199);
            arr.insert(n);
        }
        arr.display();
        arr.quickSort();
        arr.display();
    }
}

