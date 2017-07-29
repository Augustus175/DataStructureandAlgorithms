package NowCoder.offer;

/**
 * Created by zhangzhibo on 17-7-10.
 */
public class No52 {
    public static void main(String[] args) {
        No52 test = new No52();
        String str = "-2147483648";
//        System.out.println(str.indexOf(0));
        System.out.println(Integer.MIN_VALUE);
        System.out.println(test.StrToInt(str));
        System.out.println(test.gStatus);
    }

    boolean gStatus = true;

    public int StrToInt(String str) {
        if (str == null || str.length() == 0) {
            gStatus = false;
            return 0;
        }
        boolean signflag = false;
        if (str.equals(String.valueOf(Integer.MAX_VALUE))) {
            return Integer.MAX_VALUE;
        }
        if (str.equals(String.valueOf(Integer.MIN_VALUE))) {
            return Integer.MIN_VALUE;
        }
        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            signflag = true;
            if (str.length() < 2) {
                gStatus = false;
                return 0;
            }
        }
        char[] strch = null;
        int index = 0;
        if (signflag) {
            strch = new char[str.length() - 1];
            index = 1;
        } else {
            strch = new char[str.length()];
            index = 0;
        }
        for (int i = 0; i < strch.length; i++) {
            strch[i] = str.charAt(index);
            index++;
            if (strch[i] > '9' || strch[i] < '0') {
                gStatus = false;
                return 0;
            }
        }
        int result = turnDigist(strch);
        if (result == -1) {
            gStatus = false;
            return 0;
        }
        if (signflag) {
            if (str.charAt(0) == '-') {
                result = -result;
            }
        }
        return result;

    }

    public int turnDigist(char[] strch) {
        int num = 0;
        int tmp;
        for (int i = 0; i < strch.length; i++) {
            tmp = num;
            num = num * 10 + (strch[i] - '0');
            if (num < 0 || num < tmp) {
                return -1;
            }

        }
        return num;
    }
}
