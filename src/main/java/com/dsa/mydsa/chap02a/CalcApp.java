package com.dsa.mydsa.chap02a;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangzhibo on 17-5-21.
 */
public class CalcApp {
    public static void main(String[] args) {
        Map<Integer,Integer> count = new HashMap<>();
        for (int i = 1; i < 1024; i++) {
            Calc(count,i);
        }
        for (int i = 1; i < 1024; i++) {
            System.out.println(i+" "+count.get(i));
        }
    }

//    public static void Calc(int[] count, int i,int N) {
    public static void Calc(Map<Integer,Integer> count, int i) {
        int t = 0;
        int cur = i;
        while(i!=1)
        {
            if (i%2==0)
            {
                i = i/2;
                t++;
            }else{
                i = i*3+1;
                t++;
            }
//            if(i<N&&count[i]!=-1)
            if(count.containsKey(i))
            {
                int tmp = count.get(i)+t;
                count.put(cur,tmp) ;
                break;
            }else{
                count.put(cur,t);
            }
        }

    }
}
