package chap07;

/**
 * Created by Gavin.Stevenson on 2017/4/3.
 */
class ArrayIns2 {
    private long[] theArray;
    private int nElems;

    public ArrayIns2(int max) {
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
        recQuickSort(0, nElems - 1);
    }

    public void recQuickSort(int left, int right) {
        int size = left - right;
        if (size <= 3)
        {
            manualSort(left,right);
        }else{
            long median = medianOf3(left,right);
            int patition = partitionIt(left,right,median);
            recQuickSort(left,patition-1);
            recQuickSort(patition+1,right);

        }
        if (right - left <= 0) {
            return;
        } else {
            long pivot = theArray[right];
            int partition = partitionIt(left, right, pivot);
            recQuickSort(left, partition - 1);
            recQuickSort(partition + 1, right);
        }

    }
    public long medianOf3(int left,int right)
    {
        int center = (right - left)/2;
        if (theArray[left]>theArray[center])
        {
            swap(left,center);
        }
        if(theArray[right]<theArray[center])
        {
            swap(right,center);
        }
        if (theArray[left]>theArray[right])
        {
            swap(left, right);
        }
        return theArray[center];
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
    public void manualSort(int left,int right)
    {
        int size = right - left +1;
        if (size<=1)
        {
            return;
        }else{
            if (size ==2)
            {
                if(theArray[left]>theArray[right])
                {
                    swap(left,right);
                }
                return;
            }else{
                if (theArray[left]>theArray[right-1])
                {
                    swap(left,right-1);
                }
                if(theArray[left]>theArray[right])
                {
                    swap(right,right);
                }
                if (theArray[right-1]>theArray[right])
                {
                    swap(right-1,right);
                }
            }
        }
    }

    public int getnElems() {
        return nElems;
    }

}

public class QuickSort2App {

    public static void main(String[] args) {
        int maxSize = 16;
        ArrayIns2 arr = new ArrayIns2(maxSize);
        for (int i = 0; i < maxSize; i++) {
            long n = (int) (Math.random() * 199);
            arr.insert(n);
        }
        arr.display();
        arr.quickSort();
        arr.display();
    }
}

