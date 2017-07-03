package NowCoder.offer;

/**
 * Created by zhangzhibo on 17-6-29.
 */
public class No33 {
    public int FindGreatestSumOfSubArray(int[] array) {
        int sum = array[0];
        int max = sum;
        for (int i = 1; i < array.length; i++) {
            sum = Math.max(sum + array[i], array[i]);
            max = Math.max(sum, max);
        }
        return max;
    }
}
