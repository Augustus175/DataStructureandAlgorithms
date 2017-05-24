package OctoberAlgorithms.chap02a;

/**
 * Created by zhangzhibo on 17-5-22.
 */
public class HanoiApp {
    public static void main(String[] args) {
        move('A', 'B', 'C', 3);
    }

    public static void move(char from, char aux, char to, int n) {
        if (n==1)
        {
            moveOne(from,to);
            return;
        }
        move(from, to, aux, n - 1);
        moveOne(from, to);
        move(aux, from, to, n - 1);
    }

    public static void moveOne(char from, char to) {
        System.out.println(from + "   ------->    " + to);
    }
}
