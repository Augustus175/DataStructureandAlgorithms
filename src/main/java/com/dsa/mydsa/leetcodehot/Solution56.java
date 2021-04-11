package com.dsa.mydsa.leetcodehot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        ArrayList<int[]> outputs = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (outputs.isEmpty()) {
                outputs.add(intervals[i]);
            } else {
                int[] current = outputs.get(outputs.size() - 1);
//                There is no overlap.
                if (current[1] < intervals[i][0]) {
                    outputs.add(intervals[i]);
                } else {
                    outputs.get(outputs.size() - 1)[1] = Math.max(intervals[i][1], outputs.get(outputs.size() - 1)[1]);
                }
            }
        }
        return outputs.toArray(new int[outputs.size()][]);
    }
}
