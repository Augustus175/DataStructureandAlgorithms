package com.dsa.mydsa.NowCoder.offer;

/**
 * Created by zhangzhibo on 17-7-28.
 */
public class QuikSortText {
    public static void main(String[] args) {
       int[] test = RandomArray.getArrag(14);
        for (int tmp :
                test) {
            System.out.print(tmp+" ");
        }
        reQuikSort(test,0,test.length-1);
        System.out.println();
        for (int tmp :
                test) {
            System.out.print(tmp+" ");
        }
    }
    public static int partiton(int[] a,int left,int right,int key){
        int leftptr = left-1;
        int rightptr = right;
        while(true){
            while(leftptr<right&&a[++leftptr]<key);
            while(rightptr>0&&a[--rightptr]>key);
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
    public static void reQuikSort(int[] a,int left,int right){
        if (right<=left){
            return ;
        }else{
            int tmp = a[right];
            int partiton = partiton(a,left,right,tmp);
            reQuikSort(a,left,partiton-1);
            reQuikSort(a,partiton+1,right);
        }
    }
}
