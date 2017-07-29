package OctoberAlgorithms.chap02b;

/**
 * Created by zhangzhibo on 17-5-27.
 */
public class MaxSubarrayApp02 {
/*    this idea has a bug;
 */
    public static void main(String[] args) {

        int[] a = {1, -2, -3, -10, -4, -7, -2, -5};
        int result = MaxSubarray(a);
        System.out.println(result);
    }

    public static int MaxSubarray(int[] a) {
        int[] sum = new int[a.length];
        sum[0] = a[0];
        int m = a[0];
        for (int i = 1; i < a.length; i++) {
            sum[i] = sum[i - 1] + a[i];
            if (m > sum[i]) {
                m = sum[i];
            }
        }
//        there is a bug in this place
//        if index of m is t
//        when do a[i] - m ,i must bigger than t
        System.out.println(m);
        int result=a[0]-m;
//        int tmp;
        for (int i = 0; i < a.length; i++) {
            if (result < sum[i] - m) {
                result = sum[i] - m;
            }
        }
        return result;
    }
}
