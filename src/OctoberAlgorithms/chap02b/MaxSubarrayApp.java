package OctoberAlgorithms.chap02b;

/**
 * Created by zhangzhibo on 17-5-26.
 */
public class MaxSubarrayApp {
    public static void main(String[] args) {
        int[] a = {1, -2, 3, 10, -4, 7, 2, -5};
        int result = MaxSubarray(a);
        System.out.println(result);
    }

    public static int MaxSubarray(int[] a) {
        int sum = a[0];
        int result = sum;
        for (int i = 0; i < a.length; i++) {
            if (sum > 0) {
                sum = sum + a[i];
            } else {
                sum = a[i];
            }
            result = Math.max(result, sum);

        }
        return result;

    }
}
