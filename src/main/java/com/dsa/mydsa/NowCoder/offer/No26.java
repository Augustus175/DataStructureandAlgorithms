package com.dsa.mydsa.NowCoder.offer;

/**
 * Created by zhangzhibo on 17-6-26.
 */
public class No26 {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length==0){
            return false;
        }
        return juge(sequence, 0, sequence.length - 1);
    }

    /**
     *
     * @param a 后续遍历数组
     * @param start 后续遍历起始位置
     * @param end 后续遍历终止位置，也代表了根节点的位置
     * @return
     * 思路 :对于数组_____ _____o，前半段所有值____都必须小于o，后半段所有值____都必须大于o
     */
    public boolean juge(int[] a, int start, int end) {
        if (start >= end) {
            return true;
        }
        int i = end;
        while (i > start && a[i - 1] > a[end]) {
            i--;
        }
        for (int j = i - 1; j >= start; j--) {
            if (a[j] > a[end]) {
                return false;
            }
        }
        return juge(a, start, i - 1) && juge(a, i, end - 1);
    }
}
