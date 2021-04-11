package com.dsa.mydsa.leetcodehot;

import java.util.ArrayList;
import java.util.List;

public class Solution57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i = 0;
        List<int[]> result = new ArrayList<>();
        int len = intervals.length;
//                There is no overlap in left.
        while (i < len && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
//                There is  overlap.
        while (i < len && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        result.add(newInterval);
//                There is no overlap int right.
        while (i < len && intervals[i][0] > newInterval[1]) {
            result.add(intervals[i]);
            i++;
        }
//        return result.toArray(new int[0][]);
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        Solution57 solution57 = new Solution57();
        int[][] intervals = new int[][]{{1, 3}, {6, 9}};
        int[] newInterval = new int[]{2, 5};
        solution57.insert(intervals, newInterval);
    }
}
