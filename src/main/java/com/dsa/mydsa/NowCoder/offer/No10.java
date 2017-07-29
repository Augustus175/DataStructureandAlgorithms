package com.dsa.mydsa.NowCoder.offer;

/**
 * Created by zhangzhibo on 17-6-21.
 */
public class No10 {
    public static void main(String[] args) {
//        System.out.println(JumpFloor(29));
        System.out.println(Conbine(60,5));
    }

    public static int JumpFloorA(int target) {
        int t1 = 1;
        int t2 = 2;
        int total = 0;
        if (target==1||target==2)
        {
            return target;
        }
        for (int i = 3; i <=target; i++) {
            total = t1+t2;
            t1= t2;
            t2 = total;

        }
        return total;
    }
    public static int JumpFloor(int target) {
        int count = 0;
        for (int i = 0; i <= target / 2; i++) {
//            count += (factorialFloop(target - i)) / (factorialFloop(i) * factorialFloop(target - 2 * i));
            System.out.println(count);
            count += Conbine(target-i,i);
        }
        return count;
    }

    public static int factorialFloop(int n) {
        int result = 1;
        if (n==1||n==0)
        {
            return 1;
        }
        for (int i = 2; i <= n; i++) {
            result = result*i;
        }
        return result;

    }

    public static int Conbine(int m ,int n)
    {
        int big;
        int small;
        if (m-n>n)
        {
            big = m-n;
            small = n;
        }else {
            big = n;
            small = m-n;
        }
        int result =1;
        for (int i = m; i >big ; i--) {
           result = result*i;
        }
        result = result/(factorialFloop(small));
        return  result;
    }
}
