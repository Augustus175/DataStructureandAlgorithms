package com.dsa.mydsa.NowCoder.offer;

/**
 * Created by zhangzhibo on 17-6-22.
 */
public class No11 {
    public static void main(String[] args) {
        System.out.println(JumpFloorII(1));
    }

    public static int JumpFloorII(int target) {
        if (target == 1) {
            return target;
        }
        return 2 << (target - 2);
    }

    public int JumpFloorII2(int target) {
        if (target == 0 || target == 1) {
            return target;
        }
        return docub(2, target - 1);
    }

    public int docub(int n, int k) {
        if (k == 0) {
            return 1;
        }
        return k % 2 == 1 ? n * docub(n, k / 2) * docub(n, k / 2) : docub(n, k / 2) * docub(n, k / 2);
    }
}

