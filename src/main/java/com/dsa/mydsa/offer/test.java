package com.dsa.mydsa.offer;

/**
 * Created by zhangzhibo on 17-6-9.
 */
public class test {
    public static void main(String[] args) {
        int[] a = {0,1,2,3,5,6,7,8};
        System.out.println(findnid(a,4));
    }

    public static int findnid(int[] args, int key) {
        int start = 0;
        int mid = 0;
        int end = args.length;
        while (start <= end&&mid< args.length-1) {
            mid = (start + end) / 2;

            if (args[mid] == key) {
                System.out.println(key);
                break;
            } else if (args[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return mid;
    }
}
