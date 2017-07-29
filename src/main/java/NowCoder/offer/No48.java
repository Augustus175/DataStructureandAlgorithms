package NowCoder.offer;

import java.util.Arrays;

/**
 * Created by Gavin.Stevenson on 2017/7/4.
 */
public class No48 {
    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length < 5) {
            return false;
        }
        int numzero = 0;
        int gap = 0;
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                numzero++;
            } else {
                break;
            }
        }
        int small = numzero;
        int big = small + 1;
        while (big < numbers.length) {
            if (numbers[small] == numbers[big]) {
                return false;
            }
            gap += numbers[big] - numbers[small] - 1;
            small = big;
            big++;
        }
        return (gap > numzero ? false : true);
    }
}
