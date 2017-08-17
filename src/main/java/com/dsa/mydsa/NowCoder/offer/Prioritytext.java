package com.dsa.mydsa.NowCoder.offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by zhangzhibo on 17-7-10.
 */
public class Prioritytext {

    public static void main(String[] args) {
        PriorityQueue<Integer> pqueue1 = new PriorityQueue<>();
        PriorityQueue<Integer> pqueue2 = new PriorityQueue<>(1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < 10; i++) {
            pqueue1.offer(i);
            pqueue2.offer(i);
        }
        while (!pqueue1.isEmpty()){
            System.out.print(pqueue1.poll()+" ");
        }
        System.out.println();
        while (!pqueue2.isEmpty()){
            System.out.print(pqueue2.poll()+" ");
        }
    }

}
