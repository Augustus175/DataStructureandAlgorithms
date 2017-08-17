package com.dsa.mydsa.NowCoder.offer;

/**
 * Created by zhangzhibo on 17-7-5.
 */
public class No53 {
//    ues O(n) space and O(n) time
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        boolean[] tmp = new boolean[length];
        for (int i = 0; i < length; i++) {
            if (tmp[numbers[i]] == true) {
                duplication[0] = numbers[i];
                return true;
            } else {
                tmp[numbers[i]] = true;
            }
        }
        return false;


    }
//    user O(1) space and O(n) time
    public boolean duplicate02(int numbers[],int length,int [] duplication) {
        if(numbers==null||numbers.length==0||numbers.length!=length||length==0){
            return false;
        }
        for(int i = 0;i<length;i++){
            if(numbers[i]!=i){
                if(numbers[i]==numbers[numbers[i]]){
                    duplication[0] =numbers[i];
                    return true;
                }
                swap(numbers,i,numbers[i]);
                i--;
            }
        }
        return false;
    }
    public void swap(int[]  a, int i,int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}