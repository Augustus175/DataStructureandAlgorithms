package NowCoder.offer;
import java.util.ArrayList;
/**
 * Created by Gavin.Stevenson on 2017/7/4.
 */
public class No44 {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> re = new ArrayList<>();
        if (array == null || array.length == 0) {
            return re;
        }
        int start = 0;
        int end = array.length - 1;
        int result1 = Integer.MAX_VALUE;
        int result2 = 1;
        while (start < end) {
            if (array[start] + array[end] == sum) {
                if (result1 * result2 > array[start] * array[end]) {
                    result1 = array[start];
                    result2 = array[end];
                } else {
                    end--;
                }
            } else if (array[start] + array[end] > sum) {
                end--;
            } else {
                start++;
            }
        }
        if (result1 + result2 == sum) {
            re.add(result1);
            re.add(result2);
        }
        return re;
    }
}
