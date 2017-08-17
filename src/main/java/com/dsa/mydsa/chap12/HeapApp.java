package com.dsa.mydsa.chap12;

/**
 * Created by Gavin.Stevenson on 2017/4/12.
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

public class HeapApp {
    public static void main(String[] args) {
        int value1;
        int value2;
        Heap theHeap = new Heap(31);
        boolean success;
        theHeap.insert(70);
        theHeap.insert(40);
        theHeap.insert(50);
        theHeap.insert(20);
        theHeap.insert(60);
        theHeap.insert(100);
        theHeap.insert(80);
        theHeap.insert(30);
        theHeap.insert(10);
        theHeap.insert(90);
        theHeap.displayHeap();
        theHeap.remove();
        theHeap.displayHeap();
        theHeap.insert(100);
        theHeap.displayHeap();
        theHeap.chang(0, 120);
        theHeap.displayHeap();
    }
}