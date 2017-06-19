package OctoberAlgorithms.chap03b;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhangzhibo on 17-6-3.
 */
public class UnionSetFindApp {
    public static void main(String[] args) {
       int[][] graph = new int[7][7];
        for (int i = 0; i < graph.length; i++) {
            graph[i][i] = 1;
        }
        graph[0][4] = 1;
        graph[1][2] = 1;
        graph[2][3] = 1;
        graph[5][6] = 1;
        int[] result = UnionSetFind(graph);
        Set<Integer> set = new HashSet<>();
        for (int k :
                result) {
//            System.out.print(k+" ");
            set.add(k);
        }
        System.out.println(set.size());
    }

    public static int[]  UnionSetFind(int[][] graph) {
        int[] union = new int[graph.length];
        for (int i = 0; i < union.length; i++) {
            union[i] = i;
        }
        for (int i = 0; i < graph.length; i++) {
            for (int j = i; j < graph[i].length; j++) {
                if (graph[i][j] ==1)
                {
//                    union[j]= i;
//                    if (union[i] !=i)
//                    {
                        union[j] = union[i];
//                    }
                }
            }
        }
        return union;
    }
}
