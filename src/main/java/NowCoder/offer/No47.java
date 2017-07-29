package NowCoder.offer;

/**
 * Created by Gavin.Stevenson on 2017/7/4.
 */
public class No47 {
    public static void main(String[] args) {
        String str = "abcdefg";
        String s = LeftRotateString(str, 2);
        System.out.println(s);
    }

    public static String LeftRotateString(String str, int n) {
        if (str == null || str.trim().equals("")) {
            return str;
        }
        char[] strc = str.toCharArray();
        overturn(strc, 0, n - 1);
        overturn(strc, n, strc.length - 1);
        overturn(strc, 0, strc.length - 1);
        return new String(strc);
    }

    public static void overturn(char[] c, int start, int end) {
        char t;
        while (start < end) {
            t = c[start];
            c[start] = c[end];
            c[end] = t;
            start++;
            end--;
        }
    }
}
