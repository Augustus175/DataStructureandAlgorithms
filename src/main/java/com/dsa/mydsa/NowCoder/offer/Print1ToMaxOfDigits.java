package com.dsa.mydsa.NowCoder.offer;

/**
 * Created by zhangzhibo on 17-7-30.
 */
public class Print1ToMaxOfDigits {
    public static void main(String[] args) {
        printMaxofNdigist2(5);
    }
    public static void printMaxofNdigist2(int n){
        if (n<=0){
            System.out.println(-1);
            return;
        }
        int[] num = new int[n];
        for (int i = 0; i <= 9; i++) {
            num[0] = i;
            printMaxOfNdigitsRecursively(num,n-1,0);
        }
    }
    public static void printMaxOfNdigitsRecursively(int[] num, int length,int index){
        if(index>=length){
            printNum(num);
            System.out.println();
            return;
        }
        for (int i = 0; i <= 9; i++) {
            num[index+1] = i;
            printMaxOfNdigitsRecursively(num,length,index+1);
        }
    }
    public static void printNum(int[] num){
        boolean head = false;
        for (int i = 0; i < num.length; i++) {
            if (num[i]!=0&&!head){
                head = true;
                System.out.print(num[i]);
            }else if(head){
                System.out.print(num[i]);
            }
        }
    }
}
