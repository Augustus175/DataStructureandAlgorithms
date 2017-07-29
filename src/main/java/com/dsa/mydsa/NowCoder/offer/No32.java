package com.dsa.mydsa.NowCoder.offer;

import com.sun.javafx.image.impl.IntArgb;
import sun.security.action.GetLongAction;

import java.util.ArrayList;

/**
 * Created by zhangzhibo on 17-6-29.
 */
public class No32 {
    public static void main(String[] args) {
        int[] a = {4,5,1,6,2,0,7,3,8};
        ArrayList<Integer> result = GetLeastNumbers_Solution(a,4);
        for (int i :
                result) {
            System.out.print(i+" ");
        }
    }
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(input.length==0||k<0){
            return null;
        }
        int left = 0;
        int right = input.length-1;
        ArrayList<Integer> result = new ArrayList<Integer>(k);
        int index = partition(input,left,right,input[right]);
        while(index-1!=k){

            if(index-1>k){
                right = index-1;
                index = partition(input,left,right,input[right]);
            }else{
                left = index+1;
                index = partition(input,left,right,input[right]);
            }
        }
        for(int i = 0;i<k;i++){
            result.add(input[i]);
        }
        return result;

    }

    public static int partition(int[] a,int left,int right,int pivot){
        int leftptr = left-1;
        int rightptr = right;
        while(true){
            while(leftptr<right&&a[++leftptr]<pivot);
            while(rightptr>left&&a[--rightptr]>pivot);
            if(leftptr>=rightptr){
                break;
            }else{
                swap(a,leftptr,rightptr);
            }
        }
        swap(a,leftptr,right);
        return leftptr;
    }
    public static void swap(int[] a,int l,int r){
        int tmp = a[l];
        a[l] = a[r];
        a[r] = tmp;
    }
}
