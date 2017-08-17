package com.dsa.mydsa.NowCoder.offer;

/**
 * Created by zhangzhibo on 17-7-2.
 */
public class No36 {
    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(2));
    }
    public static  int GetUglyNumber_Solution(int index) {
        if(index<=0){
            return 0;
        }
        int nextindex=1;
        int multy2 = 0;
        int multy3 = 0;
        int multy5 = 0;
        int min = 1;
        int[] tmp = new int[index];
        tmp[0] = 1;
        while(nextindex<index){
            min = Min(tmp[multy2]*2,tmp[multy3]*3,tmp[multy5]*5);
            tmp[nextindex]=min;
            while(tmp[multy2]*2<=min){
                multy2++;
            }
            while(tmp[multy3]*3<=min){
                multy3++;
            }
            while(tmp[multy5]*5<=min){
                multy5++;
            }
            nextindex++;
        }
        tmp=null;
        return min;
    }
    public static int Min(int a,int b,int c){
        int tmp = (a>b ? b : a);
        tmp = (tmp>c ? c:tmp);
        return tmp;
    }
}
