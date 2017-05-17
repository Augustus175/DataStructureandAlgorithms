package OctoberAlgorithms.chap02a;

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
                next[j] = k;
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
