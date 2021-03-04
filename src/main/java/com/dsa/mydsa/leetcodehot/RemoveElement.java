package com.dsa.mydsa.leetcodehot;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;
        if (nums.length < 1) {
            return 0;
        }
        while (i < j) {
            if (nums[i] == val) {
                while (j > i) {
                    if (nums[j] != val) {
                        nums[i] = nums[j];
                        j--;
                        break;
                    }
                    j--;
                }
            } else {
                i++;
            }
        }

        if (nums[i] == val) {
            return i;
        } else {
            return i + 1;
        }
    }

    public static void main(String[] args) {
        int[] num = new int[]{3, 2, 2, 3};
        RemoveElement removeElement = new RemoveElement();
        int length = removeElement.removeElement(num, 3);
        System.out.println(length);

    }
}
