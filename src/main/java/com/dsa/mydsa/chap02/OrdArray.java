package com.dsa.mydsa.chap02;

/**
 * Created by zhangzhibo on 17-3-1.
 * Page36
 */
class OrdArray {

    private long[] a;
    private int nElems;

    public OrdArray(int max) {
        a = new long[max];
        nElems = 0;
    }


    public int find(long searchKey) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn = 0;
        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (a[curIn] == searchKey) {
                return curIn;
            } else if (upperBound < lowerBound) {
                return nElems;
            } else {
                if (a[curIn] < searchKey) {
                    lowerBound = curIn + 1;
                } else {
                    upperBound = curIn - 1;
                }
            }
        }
    }
//chap06 Page203;
    public int recfind(long searchKey) {
        return recFind(0, nElems, searchKey);
    }

    public int recFind(int lowerBound, int upperBound, long searchKey) {
        if (upperBound < lowerBound) {
            return nElems;
        } else {
            int curIn = (upperBound + lowerBound) / 2;
            if (a[curIn] == searchKey) {
                return curIn;
            } else if (a[curIn] > searchKey) {
                return recFind(lowerBound, curIn - 1, searchKey);
            } else {
                return recFind(curIn + 1, upperBound, searchKey);
            }
        }
    }

    public boolean insert(long value) {
        int j;
        if (nElems > a.length - 1) {
            return false;
        } else {
            for (j = 0; j < nElems; j++) {
                if (a[j] > value) {
                    break;
                }
            }
            for (int i = nElems; i > j; i--) {
                a[i] = a[i - 1];
            }
            a[j] = value;
            nElems++;
            return true;
        }

    }

    public boolean delete(long value) {
        int j = find(value);
        if (j == nElems) {
            return false;
        } else {
            for (int i = j; i < nElems - 1; i++) {
                a[i] = a[i + 1];
            }
            nElems--;
            return true;
        }
    }

    public void display() {
        for (int i = 0; i < nElems - 1; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println(a[nElems - 1]);
    }

}
