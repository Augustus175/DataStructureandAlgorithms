package com.dsa.mydsa.NowCoder.offer;

/**
 * Created by zhangzhibo on 17-6-22.
 */
public class No14 {
    public static void main(String[] args) {
        System.out.println(Power(3, -3));
    }

    public static double Power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        boolean flag = false;
        if (exponent < 0) {
            flag = true;
            exponent = 0 - exponent;
        }
        double result = Power(base, exponent >> 1);
        result = result * result;
        if ((exponent & 1) == 1) {
            result = result * base;
        }
        if (flag)
        {
            result = 1/result;
        }
        return result;

    }
}
