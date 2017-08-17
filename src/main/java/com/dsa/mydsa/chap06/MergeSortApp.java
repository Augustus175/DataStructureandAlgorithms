package com.dsa.mydsa.chap06;

/**
 * Created by zhangzhibo on 17-3-24.
 */
public class MergeSortApp {
    public static void main(String[] args) {
        int[] a = {95, 2, 15, 36, 45, 95, 1, 235, 15, 7, 9, 54, 2};
        for(int i : a){
            System.out.print(i + " ");
        }
        System.out.println();
        mergeArr(a,0,a.length-1);
        for (int i : a)
        {
            System.out.print(i + " ");
        }
    }

    public static void mergeArr(int[] a, int begin, int last) {
        if (begin < last) {
            int mid = (begin + last) / 2;
            System.out.println("now is left");
            System.out.println("begin is : "+begin+ " , last is :" + mid);
            mergeArr(a, begin, mid);
            System.out.println("now is right");
            int t = mid +1;
            System.out.println("begin is : " + t+ " , last is "+ last);
            mergeArr(a, mid + 1, last);
            System.out.println("now mergging ! ");
            merge(a, begin, mid, last);
        }
    }

    public static void merge(int[] a, int first, int mid, int last) {
        int[] tmp = new int[last - first + 1];
        int i = first;
        int j = mid + 1;
        int k = 0;
        System.out.println("merge the num of array:");
        System.out.println("  first to mid of array");
        System.out.print("   ");
        for (int l = first; l <=mid ; l++) {
            System.out.print(a[l] + " ");
        }
        System.out.println();
        System.out.println("  mid to last of array");
        System.out.print("   ");
        for (int l = mid+1; l <=last ; l++) {
            System.out.print(a[l] + " ");
        }

        System.out.println();
        while (i <= mid && j <= last) {
            if (a[i] < a[j]) {
                tmp[k] = a[i];
                k++;
                i++;
            } else {
                tmp[k] = a[j];
                k++;
                j++;
            }
        }
        while (i <= mid) {
            tmp[k] = a[i];
            k++;
            i++;
        }
        while (j <= last) {
            tmp[k] = a[j];
            k++;
            j++;
        }
        System.out.println("merged is :");
        for (int n = 0; n < tmp.length; n++) {
            a[n+first] = tmp[n];
            System.out.print(a[n+first]+" ");
        }
        System.out.println();
        System.out.println("------------------------------------------");
    }
}
