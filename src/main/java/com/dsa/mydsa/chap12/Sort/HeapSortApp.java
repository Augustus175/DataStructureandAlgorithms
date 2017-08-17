package com.dsa.mydsa.chap12.Sort;

/**
 * Created by Gavin.Stevenson on 2017/4/13.
 */

class Node {
    public int iData;

    public Node(int key) {
        this.iData = key;
    }

    public int getKey() {
        return iData;
    }

    public void setiData(int key) {

        this.iData = key;
    }

    public void displayNode() {
//        System.out.print("( " + this.iData + " , " + this.fData + " ) ");
        System.out.print("( " + this.iData + " ) ");
    }

}

class Heap {
    private int currentSize;
    private int maxSize;
    private Node[] heapArray;

    public Heap(int mx) {
        maxSize = mx;
        currentSize = 0;
        heapArray = new Node[maxSize];
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean insert(int key) {
        if (currentSize == maxSize) {
            return false;
        }
        Node bottom = new Node(key);
        heapArray[currentSize] = bottom;
        trickleUp(currentSize++);
        return true;
    }

    public void trickleUp(int index) {
        int parent = (index - 1) / 2;
        Node bottom = heapArray[index];
        while (index > 0 && heapArray[parent].getKey() < bottom.getKey()) {
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = (parent - 1) / 2;
        }
        heapArray[index] = bottom;
    }

    public Node remove() {
        Node root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return root;
    }

    public void trickleDown(int index) {
        int largerChild;
        Node top = heapArray[index];
        while (index < currentSize / 2) {
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;
            if (rightChild < currentSize && heapArray[leftChild].getKey() < heapArray[rightChild].getKey()) {
                largerChild = rightChild;
            } else {
                largerChild = leftChild;
            }
            if (top.getKey() >= heapArray[largerChild].getKey()) {
                break;
            }
            heapArray[index] = heapArray[largerChild];
            index = largerChild;
        }
        heapArray[index] = top;
    }

    public boolean chang(int index, int newValue) {
        if (index < 0 || index >= currentSize) {
            return false;
        }
        int oldValue = heapArray[index].getKey();
        heapArray[index].setiData(newValue);
        if (oldValue < newValue) {
            trickleUp(index);
        } else {
            trickleDown(index);
        }
        return true;
    }

    public void insertAt(int index, Node newNode) {
        heapArray[index] = newNode;
    }

    public void incrementSize() {
        currentSize++;
    }

    public void displayArray() {
        for (int i = 0; i < maxSize; i++) {
            System.out.print(heapArray[i].getKey() + " ");
        }
        System.out.println();
    }

    public void displayHeap() {
        System.out.print("heapArray: ");
        for (int i = 0; i < currentSize; i++) {
            if (heapArray[i] != null) {
                System.out.print(heapArray[i].getKey() + " ");
            } else {
                System.out.print("-- ");
            }
        }
        System.out.println();
        int nBanks = 32;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0;
        String dots = "----------------------------------------------------------";
        System.out.println(dots + dots);
        while (currentSize > 0) {
            if (column == 0) {
                for (int k = 0; k < nBanks; k++) {
                    System.out.print("  ");
                }
            }
            System.out.print(heapArray[j].getKey());
            if (++j == currentSize)
                break;
            if (++column == itemsPerRow) {
                nBanks /= 2;
                itemsPerRow *= 2;
                column = 0;
                System.out.println();
            } else {
                for (int i = 0; i < nBanks * 2 - 2; i++) {
                    System.out.print("  ");
                }
            }
        }
        System.out.println("\n" + dots + dots);
    }
}

public class HeapSortApp {
    public static void main(String[] args) {
        int value1;
        int value2;
        int size = 31;
        Heap theHeap = new Heap(size);
        for (int i = 0; i < 31; i++) {
            int random = (int) (Math.random() * 99);
            Node newNode = new Node(random);
            theHeap.insertAt(i, newNode);
            theHeap.incrementSize();
        }
        System.out.println("Random : ");
        theHeap.displayArray();
        theHeap.displayArray();
        for (int i = size / 2 - 1; i >= 0; i--) {
            theHeap.trickleDown(i);
        }
        System.out.println("Heap : ");
        theHeap.displayArray();
        theHeap.displayHeap();
        for (int i = size-1; i >= 0 ; i--) {
            Node biggestnode = theHeap.remove();
            theHeap.insertAt(i, biggestnode);
        }
        System.out.println("Sorted : ");
        theHeap.displayArray();
        theHeap.displayHeap();

    }
}
