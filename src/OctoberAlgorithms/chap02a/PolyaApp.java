package OctoberAlgorithms.chap02a;

/**
 * Created by zhangzhibo on 17-5-22.
 */
public class PolyaApp {
    public static void main(String[] args) {
        int n = 7;
        int num = (int) Math.pow(2, n );
        boolean[] flag = new boolean[num];
        for (int i = 0; i < num; i++) {
            int t = i;
            for (int j = 0; j <  n; j++) {
                t = leftRoll(t, n);
                if (t > i) {
                    flag[t] = true;
                } else if (t < i) {
                    flag[i] = true;
                } else {
                    break;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < num; i++) {
            if (!flag[i]) {
                count++;
                System.out.println(i);
            }
        }
        System.out.println(count);
    }

    public static int leftRoll(int t, int n) {

        int k;
        int m = t;
//        k = m >> 7;
        k = m >> (n - 1);
        m = m << 1;
//        m = (m) & (255);
        n = (int) Math.pow(2, n) - 1;
        m = (m) & (n);
        m = m + k;
//        System.out.println(m);
//        StringBuilder sb2 = new StringBuilder(Integer.toBinaryString(m));
//        while (sb2.length() < 8) {
//            sb2.insert(0, 0);
//        }
//        System.out.println(sb2.toString());
        return m;
    }
}
