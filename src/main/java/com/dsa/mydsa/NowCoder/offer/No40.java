package com.dsa.mydsa.NowCoder.offer;

/**
 * Created by Gavin.Stevenson on 2017/7/3.
 */
public class No40 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 3, 3, 3, 3, 4, 5};
        int result = 0;
        if (findFirst(a, 0, a.length - 1, 3) == -1) {
            result = 0;
        } else {
            result = findLast(a, 0, a.length - 1, 3)-findFirst(a, 0, a.length - 1, 3)+1;
        }
        System.out.println(result);
        System.out.println(findFirst(a, 0, a.length - 1, 3));
        System.out.println(findLast(a, 0, a.length - 1, 3));
    }

    public static int GetNumberOfK(int [] array , int k) {
        if(array==null||array.length==0){
            return 0;
        }
        int result = 0;
        if (findFirst(array, 0, array.length - 1, k) == -1) {
            result = 0;
        } else {
            result = findLast(array, 0, array.length - 1, k)-findFirst(array, 0, array.length - 1, k)+1;
        }
        return result;
    }
    public static int findFirst(int[] a, int start, int end, int key) {
        int mid;
        while (true) {
            mid = (start + end) >> 1;
            if (a[mid] == key) {
                if (mid == 0 || mid > 0 && a[mid - 1] != key) {
                    return mid;
                } else {
                    end = mid - 1;
                }
            } else if (start >= end) {
                return -1;
            } else if (a[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
    }

    public static int findLast(int[] a, int start, int end, int key) {
        int mid;
        while (true) {
            mid = (start + end) >> 1;
            if (a[mid] == key) {
                if (mid == a.length - 1 || mid < a.length - 1 && a[mid + 1] != key) {
                    return mid;
                } else {
                    start = mid + 1;
                }
            } else if (start >= end) {
                return -1;
            } else if (a[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
    }
}
