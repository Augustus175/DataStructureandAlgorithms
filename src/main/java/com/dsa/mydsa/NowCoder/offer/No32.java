package com.dsa.mydsa.NowCoder.offer;

import com.sun.javafx.image.impl.IntArgb;
import sun.security.action.GetLongAction;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

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
        while(index!=k-1){

            if(index>k-1){
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
        System.out.println(leftptr);
        return leftptr;
    }
    public static void swap(int[] a,int l,int r){
        int tmp = a[l];
        a[l] = a[r];
        a[r] = tmp;
    }
    public ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        //检查输入的特殊情况
        if(input==null || input.length<=0 || input.length<k){
            return list;
        }
        //构建最大堆
        for(int len=k/2-1; len>=0; len--){
            adjustMaxHeapSort(input,len,k-1);
        }
        //从第k个元素开始分别与最大堆的最大值做比较，如果比最大值小，则替换并调整堆。
        //最终堆里的就是最小的K个数。
        int tmp;
        for(int i=k; i<input.length; i++){
            if(input[i]<input[0]){
                tmp=input[0];
                input[0]=input[i];
                input[i]=tmp;
                adjustMaxHeapSort(input,0,k-1);
            }
        }
        for(int j=0; j<k; j++){
            list.add(input[j]);
        }
        return list;
    }

    public void adjustMaxHeapSort(int[] input, int pos, int length){
        int temp;
        int child;
        for(temp=input[pos]; 2*pos+1<=length; pos=child){
            child=2*pos+1;
            if(child<length && input[child]<input[child+1]){
                child++;
            }
            if(input[child]>temp){
                input[pos]=input[child];
            }else{
                break;
            }
        }
        input[pos]=temp;
    }
    public static ArrayList<Integer> GetLeastNumbers_Solution3(int[] a,int n){
        ArrayList<Integer> result = new ArrayList<>();
        if (a==null||a.length==0||a.length<n||n==0){
            return result;
        }
        Queue<Integer> heap = new PriorityQueue<>(n,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1,Integer o2){
                return o2-o1;
            }
        });
        for (int i = 0; i < n; i++) {
            heap.offer(a[i]);
        }
        for (int i = n; i < a.length; i++) {
            if (a[i]<heap.peek()){
                heap.poll();
                heap.offer(a[i]);
            }
        }
        while(!heap.isEmpty()){
            result.add(heap.poll());
        }
        return result;
    }
}
