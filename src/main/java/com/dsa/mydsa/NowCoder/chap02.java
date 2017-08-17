package com.dsa.mydsa.NowCoder;

/**
 * Created by Gavin.Stevenson on 2017/4/21.
 */
public class chap02 {
    public int[] selectionSort(int[] A, int n) {
        // write code here

        for(int i = 0;i< n;i++){
            int min = A[i];
            int k = i;
            for(int j = i+1;j<n;j++){
                if(min > A[j]){
                    min = A[j];
                    k = j;
                }
            }
            A[k] = A[i];
            A[i] = min;

        }
        return A;
    }
    public int[] insertionSort(int[] A, int n) {
        // write code here
        for(int i = 0;i<n;i++)
        {
            int tmp
                    = A[i];
            int k = -1;
            for(int j = i-1; j>= 0;j--){
                if(tmp < A[j]){
                    A[j+1] = A[j];
                    A[j] = tmp;
                }else{

                    break;
                }
            }


        }
        return A;

    }
    public static int[] mergeSort(int[] A, int n) {
        // write code here
        themergesort(A,0,n-1);
        return A;
    }
    public static void themergesort(int[] A,int first, int last){
        if(first<last){
            int mid = (last+first)/2;
            themergesort(A,first,mid);
            themergesort(A,mid+1,last);
            mergearray(A,first,mid,last);
        }
    }
    public static void mergearray(int[] A,int first,int mid,int last ){
        int i = first;
        int j = mid +1;
        int k = 0;
        int[] tmp =  new int[last - first +1];
        while(i<=mid && j<=last){
            if(A[i]<A[j]){
                tmp[k++] = A[i++];
            }else{
                tmp[k++] = A[j++];
            }
        }
        while(j<=last){
            tmp[k++] = A[j++];
        }
        while(i<=mid){
            tmp[k++] = A[i++];
        }
        for(int m = 0;m<tmp.length;m++){
            A[first+m] = tmp[m];
        }
    }


    public static void main(String[] args) {
        int[] a = {1,5,2,7,4,9};
        mergeSort(a,a.length);
    }
}
