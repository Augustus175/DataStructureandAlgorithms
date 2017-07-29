package com.dsa.mydsa.NowCoder.offer;

import java.util.ArrayList;

/**
 * Created by Gavin.Stevenson on 2017/7/4.
 */
public class No45 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (sum < 3) {
            return result;
        }
        int small = 1;
        int big = 2;
        int mid = (1 + sum) >> 1;
        int cursum = small + big;
        while (small < mid) {

            if (sum == cursum) {
                result.add(addSequence(small, big));
            }
            while (cursum > sum && small < mid) {
                cursum -= small;
                small++;
//                cursum did not sum any number,just minus
                if (sum == cursum) {
                    result.add(addSequence(small, big));
                }
            }
            big++;
            cursum += big;
        }
        return result;
    }

    public ArrayList<Integer> addSequence(int a, int b) {
        ArrayList<Integer> re = new ArrayList<>();
        for (int i = a; i <= b; i++) {
            re.add(i);
        }
        return re;
    }
}
