package NowCoder.offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhangzhibo on 17-7-10.
 */
public class No67 {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> windowMax = new ArrayList<>();
        if (num == null || num.length < 1 || size < 1||num.length<size) {
            return windowMax;
        }
        Deque<Integer> idx = new LinkedList<>();
        for (int i = 0; i < num.length && i < size; i++) {
            while (!idx.isEmpty() && num[i] > num[idx.getLast()]) {
                idx.removeLast();
            }
            idx.addLast(i);
        }

        for (int i = size; i < num.length; i++) {
            windowMax.add(num[idx.getFirst()]);
            while (!idx.isEmpty() && num[i] > num[idx.getLast()]) {
                idx.removeLast();
            }
            if (!idx.isEmpty() && idx.getFirst() <= (i - size)) {
                idx.removeFirst();
            }
            idx.addLast(i);
        }
        windowMax.add(num[idx.getFirst()]);
        return windowMax;
    }
}
