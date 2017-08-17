package com.dsa.mydsa.NowCoder.offer;

/**
 * Created by zhangzhibo on 17-8-10.
 */
public class No48_offer {
    public static void main(String[] args) {
        String str = "araacaafa";
        System.out.println(findLength(str.toCharArray()));

    }

    public static int findLength(char[] strc) {
        int[] local = new int[26];
        for (int i = 0; i < local.length; i++) {
            local[i] = -1;
        }
        int tmp = 0;
        int max = 0;
        for (int i = 0; i < strc.length; i++) {
            int lo = local[strc[i] - 'a'];
            if (lo == -1) {
                tmp++;
            } else {
                int d = i - lo;
                if (d<=tmp){
                    max = Math.max(tmp, max);
                    tmp = d;
                }else{
                   tmp++;
                }
            }
            local[strc[i] - 'a'] = i;
            max = Math.max(tmp, max);
        }
        max = Math.max(tmp, max);
        return max;
    }
}
