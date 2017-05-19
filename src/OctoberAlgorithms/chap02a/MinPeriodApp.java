package OctoberAlgorithms.chap02a;

/**
 * Created by zhangzhibo on 17-5-18.
 */
public class MinPeriodApp {
    public static void main(String[] args) {
//        String str = "abcdabcdabcdabcd";
//        String str = "abcabcabcabc";
        String str = "aaaa";
        int minperiod = MinPeriod(str);
        System.out.println(minperiod);
    }

    public static int MinPeriod(String str) {
        if (str.length() == 0) {
            return -1;
        }
        char[] strch = new char[str.length() + 1];
        for (int i = 0; i < str.length(); i++) {
            strch[i] = str.charAt(i);
        }
        strch[str.length()] = '\0';
        int len = strch.length;
        int[] next = new int[len];
        int k = -1;
        int j = 0;
        next[0] = -1;
        while (j < len - 1) {
            if (k == -1 || strch[k] == strch[j]) {
                k++;
                j++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        next[0] = 0;
        int nlast = next[len - 1];
        if (nlast == 0) {
            return -1;
        }
        if ((len - 1) % (len - 1 - nlast) == 0) {
            return len - 1 - nlast;
        }
        return -1;
    }
}
