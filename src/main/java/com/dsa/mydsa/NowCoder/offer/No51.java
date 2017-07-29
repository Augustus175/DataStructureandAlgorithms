package com.dsa.mydsa.NowCoder.offer;

/**
 * Created by zhangzhibo on 17-7-5.
 */
public class No51 {
    public int Add(int num1,int num2) {
        int sum= 0;
        int carry = 0;
        do{
            sum = num1^num2;
            carry = ((num1&num2)<<1);

            num1 = sum;
            num2 = carry;
        }while(carry!=0);
        return sum;
    }
}
