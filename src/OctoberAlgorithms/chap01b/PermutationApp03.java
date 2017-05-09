package OctoberAlgorithms.chap01b;

/**
 * Created by zhangzhibo on 2017/5/9.
 */
public class PermutationApp03 {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int size = a.length;

        StringBuilder str = new StringBuilder();
        for(int i : a)
        {
            str.append(i);
        }
        System.out.println(str.toString());
        while(GetNextPermutation(a,size))
        {
            str = new StringBuilder();
            for(int i : a)
            {
                str.append(i);
            }
            System.out.println(str.toString());
        }
    }

    public static boolean GetNextPermutation(int[] a, int size) {
        int i = size - 2;
        while (i >= 0 && a[i] > a[i + 1]) {
            i--;
        }
        if (i < 0) {
            return false;
        }
        int j = size - 1;
        while (a[j] <= a[i]) {
            j--;
        }

        swap(a, i, j);
        Reverse(a, i + 1, size - 1);
        return true;

    }

    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void Reverse(int[] a, int from, int to) {
        int t;
        while (from < to) {
            t = a[from];
            a[from] = a[to];
            a[to] = t;
            from++;
            to--;
        }

    }
}
