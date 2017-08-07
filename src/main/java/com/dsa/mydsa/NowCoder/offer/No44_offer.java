package com.dsa.mydsa.NowCoder.offer;

/**
 * Created by zhangzhibo on 17-8-6.
 */
public class No44_offer {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int t = (int)(Math.random()*1);
            if (digitAtIndex(t)!=digitAtIndex2(t)){
                System.out.println(233333);
            }
        }
//        System.out.println(digitAtIndex2(1001));
    }
    public static int digitAtIndex(int n){
        if (n<0){
            return n;
        }
        if (n<10){
            return n;
        }else{
            n = n-10;
        }
        int count = 2;
        int t = 90;
        while(n-t*count>0){
            n -=(t*count);
            t*=10;
            count++;
        }
        int p = n/count;
        int q = n%count;
        int tmp = (int) Math.pow(10,count-1)+p;
        int result = digit(tmp,q);
        return result;
    }
    public static int digit(int n,int i){
        int tmp = n;
        int count = 1;
        int j = 10;
        while(tmp-j>=0){
            count++;
            j*=10;
        }
//        while(count-i-1>0){
//            n=n/10;
//            count--;
//        }
//        return n%10;
        return (int)(n%Math.pow(10,count-i))/10;
    }
    public static int digitAtIndex2(int n){
        if (n<0){
            return -1;
        }
        if(n-10<0){
            return n;
        }
        int count = 1;
        int num = countOfInteger(1);
        while(n-num*count>0){
            n -= num*count;
            count++;
            num = countOfInteger(count);
        }
        int p = n/count;
        int q = n%count;
        int tmp = (int) Math.pow(10,count-1)+p;
        int result = digit(tmp,q);
        return result;
    }
    public static int countOfInteger(int n){
        if (n==1){
            return 10;
        }
        return (int)(9*Math.pow(10,n-1));
    }
}
