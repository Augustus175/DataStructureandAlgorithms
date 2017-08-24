package com.dsa.mydsa.NowCoder.offer;

/**
 * Created by zhangzhibo on 17-6-19.
 */
public class No03 {
    public static void main(String[] args) {
        int[][] array = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(Find(7, array));
    }

    //从右上角开始遍历，比当前值小列-1,比当前之大行+1
    public static boolean Find(int target, int[][] array) {
        int rows = array.length;
        int cols = array[0].length;
        int i = 0;
        int j = cols - 1;
        while (i <= rows - 1 && j >= 0) {
            if (target == array[i][j]) {
                return true;
            } else if (target < array[i][j]) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
