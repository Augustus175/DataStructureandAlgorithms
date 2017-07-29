package OctoberAlgorithms.chap02b;

/**
 * Created by zhangzhibo on 17-5-26.
 */
public class FirstMissNumberApp {
    public static void main(String[] args) {
        int[] a = {0, 3, 5, 1, 2, -3, 7, 4, 8};
        int result = FirstMissNumber(a);
        System.out.println(result);
    }

    public static int FirstMissNumber(int[] a) {
        int size = a.length;
        int i = 1;
        while (i < size) {
            if (a[i] == i) {
                i++;
            } else if ((a[i] < i) || (a[i] > size - 1) || (a[i] == a[a[i]])) {
                a[i] = a[size - 1];
                size--;
            } else {//a[i] > i
                swap(a, i, a[i]);
            }
        }
        return i;

    }

    public static void swap(int[] a, int x, int y) {
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;

    }
}
