package com.dsa.mydsa.OctoberAlgorithms.chap02b;

/**
 * Created by zhangzhibo on 17-5-26.
 */
public class FindMininRollApp {
    public static void main(String[] args) {
        int[] a = {4,5,6,0,1,2,3};
        int result = FindMininRoll(a);
        System.out.println(result);
    }

    public static int FindMininRoll(int[] a) {
        int mid = 0;
        int left = 0;
        int right = a.length -1;
        while(left< right)
        {
            mid = (right+left)/2;
            if (a[mid]<a[right])
            {
                right = mid;
            }else if (a[mid]>a[right])
            {
                left = mid+1;
            }else{
                right = right-1;
            }
        }
        return a[left];
    }

}
