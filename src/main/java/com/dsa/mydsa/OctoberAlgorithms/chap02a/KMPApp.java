package com.dsa.mydsa.OctoberAlgorithms.chap02a;

/**
 * Created by zhangzhibo on 17-5-17.
 */
public class KMPApp {
    public static void main(String[] args) {
        String str = "abaabcaba";
        char[] patern = str.toCharArray();
        String test = "0123456abaabcaba";
        char[] testchar = test.toCharArray();
        int answer = KMP(testchar,patern);
        System.out.println(answer);
        int[] next1 = new int[patern.length];
        int[] next2 = new int[patern.length];
        GetNext(patern,next1);
        GetNext2(patern,next2);
        for (int m :
                next1) {
            System.out.print(m+" ");
        }
        System.out.println();
        for (int n :
                next2) {
            System.out.print(n+" ");
        }
    }

    public static void GetNext(char[] p, int[] next) {
        int nLen = p.length;
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < nLen - 1) {
            if (k == -1 || p[k] == p[j]) {
                j++;
                k++;
                System.out.println(k+" "+ j);
                next[j] = k;
            } else {
                k = next[k];
            }

        }

    }
    public static void GetNext2(char[] p, int[] next) {
        int nLen = p.length;
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < nLen - 1) {
            if (k == -1 || p[k] == p[j]) {
                j++;
                k++;
                if(p[j]==p[k])
                {
                    next[j]=next[k];
                }else{
                    next[j] = k;
                }
            } else {
                k = next[k];
            }

        }

    }

    public static int KMP(char[] str, char[] patern) {
        int length = str.length;
        int[] next = new int[length];
        int ans = -1;
        GetNext(patern, next);
        int i = 0;
        int j = 0;
        while (i < length) {
            if (j == -1 || str[i] == patern[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
            if(j == patern.length)
            {
                ans = i-patern.length;
                break;
            }
        }

        return ans;

    }
}
