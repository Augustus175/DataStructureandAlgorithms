package com.dsa.mydsa.NowCoder.offer;

/**
 * Created by Gavin.Stevenson on 2017/7/3.
 */
public class No43 {
    public static void main(String[] args) {
        int[] a = {1,1,2,2,3,3,4,5,5,6,7,7};
        int[] b = new int[1];
        int[] c = new int[1];
        FindNumsAppearOnce(a,b,c);
        System.out.println(b[0]+" "+ c[0]);
    }
    public  static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array==null||array.length==0){
            num1=num2=null;
        }
        num1[0] = 0;
        num2[0] = 0;
        int tmp= 0;
        for(int i = 0;i<array.length;i++){
            tmp= (tmp^array[i]);
        }
        tmp = findlocaltion(tmp);
        for(int i=0;i<array.length;i++){
            if((array[i]&tmp)!=0){
                num1[0] = (num1[0]^array[i]);
            }else{
                num2[0] = (num2[0]^array[i]);
            }
        }

    }
    public static int findlocaltion(int num){
        int result = 1;
        while((num&result)==0){
            result= result<<1;
        }
        return result;
    }
}
