package com.dsa.mydsa.OctoberAlgorithms.chap01b;

/**
 * Created by zhangzhibo on 2017/5/12.
 */
public class CalcCountApp {
    public static void main(String[] args) {
        System.out.println(CalcCount(5));
    }

    public static int CalcCount(int n) {
        int nNonRepeat = 3;
        int nRepeat = 0;
        for (int i = 2; i <=n ; i++) {
            int t = nNonRepeat;
            nNonRepeat = 2*nNonRepeat+2*nRepeat;
            nRepeat = t;
        }
        return nNonRepeat+nRepeat;

    }
}
