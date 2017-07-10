package NowCoder.offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by zhangzhibo on 17-7-10.
 */
public class No66 {
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(17, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    private int count = 0;

    public void Insert(Integer num) {
        if (count % 2 == 0) {
            maxHeap.offer(num);
            int tmp = maxHeap.poll();
            minHeap.offer(tmp);
        } else {
            minHeap.offer(num);
            int tmp = minHeap.poll();
            maxHeap.offer(tmp);
        }
        count++;
    }

    public Double GetMedian() {
        return count%2==0 ? (double)(maxHeap.poll()+minHeap.poll())/2:minHeap.poll();
    }
}
