package NowCoder.offer;

/**
 * Created by zhangzhibo on 2017/6/30.
 */
public class No34 {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for (int i = 1; i <= n; i *= 10) {
            int a = n / i;
            int b = n % i;
            count = count + ((a + 8) / 10) * i + (a % 10 == 1 ? 1 : 0) * (b + 1);
        }
        return count;
    }
}
