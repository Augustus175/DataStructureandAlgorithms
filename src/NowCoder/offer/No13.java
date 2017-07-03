package NowCoder.offer;

/**
 * Created by zhangzhibo on 17-6-22.
 */
public class No13 {
    public static void main(String[] args) {
        System.out.println(NumberOf1(-2));
        System.out.println(NumberOf12(-2));
    }

    public static int NumberOf1(int n) {
        char[] c = Integer.toBinaryString(n).toCharArray();
        int result = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '1') {
                result++;
            }
        }
        return result;
    }
    public static int NumberOf12(int n) {
        int result= 0;
        while(n!=0)
        {
            result++;
            n = n&(n-1);
        }
        return result;
    }
}
