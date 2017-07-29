package com.dsa.mydsa.chap02a;

/**
 * Created by zhangzhibo on 17-5-20.
 */
public class NewtownSquaerApp {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Calc(i));
        }
//        System.out.println(1e-6);
    }

    public static float Calc(float a) {
        if(a<(1e-6))
        {
            return  0;
        }
        float x = a/2;
        float t =a;
        while (Math.abs(x-t)>(1e-6))
        {
            t = x;
            x =(x+a/x)/2;
        }
        return x;


    }
}

