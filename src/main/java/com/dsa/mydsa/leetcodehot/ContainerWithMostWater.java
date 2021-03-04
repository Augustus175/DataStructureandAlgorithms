package com.dsa.mydsa.leetcodehot;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int res = 0;
        int volum = 0;
        while (i < j) {
            if (height[i] < height[j]) {
                volum = height[i] * (j - i);
                res = Math.max(res, volum);
                i++;
            } else {
                volum = height[j] * (j - i);
                res = Math.max(res, volum);
                j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int volum = containerWithMostWater.maxArea(height);
        System.out.println(volum);
    }
}
