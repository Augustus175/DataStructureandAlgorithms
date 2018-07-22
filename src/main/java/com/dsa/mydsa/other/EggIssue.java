package com.dsa.mydsa.other;

/**
 * @author zhangzhibo-linux
 * @date 18-7-21 上午11:01
 */
public class EggIssue {
    public static void main(String[] args) {
        System.out.println(findNum1(2, 100));
        System.out.println(findFlood(2, 100));
        System.out.println(findFloorBetter(2, 100));
    }

    public static int findNum1(int N, int M) {
        if (N < 1 || M < 1) {
            return 0;
        }
        int[] eggs = new int[N + 1];
        int[] floors = new int[M + 1];
        int[][] catche = new int[N + 1][M + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                catche[i][j] = j;
            }
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                for (int k = 1; k < j; k++) {
                    catche[i][j] = Math.min(catche[i][j], 1 + Math.max(catche[i - 1][k - 1], catche[i][j - k]));
                }
            }
        }
        return catche[N][M];
    }

    public static int findFlood(int N, int M) {
        if (N < 1 || M < 1) {
            return 0;
        }
        int[][] cache = new int[N + 1][M + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                cache[i][j] = j;
            }
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                for (int k = 1; k < j; k++) {
                    cache[i][j] = Math.min(cache[i][j], 1 + Math.max(cache[i - 1][k - 1], cache[i][j - k]));
                }
            }
        }
        return cache[N][M];
    }

    public static int findFloorBetter(int N, int M) {
        int[] preresult = new int[M + 1];
        int[] result = new int[M + 1];
        for (int i = 0; i < M + 1; i++) {
            result[i] = i;
        }
        for (int i = 2; i <= N; i++) {
            System.arraycopy(result, 0, preresult, 0, result.length);
            for (int j = 1; j <= M; j++) {
                for (int k = 1; k < j; k++) {
                    result[j] = Math.min(result[j], 1 + Math.max(preresult[k - 1], result[j - k]));
                }
            }
        }
        return result[M];
    }
}
