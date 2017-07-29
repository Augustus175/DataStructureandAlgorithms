package chap03;

/**
 * Created by zhangzhibo on 17-3-2.
 *  Page 70
 */
public class InsertSortApp {
    public static void main(String[] args) {
        InsertSort arr = new InsertSort(10);
        arr.insert(12);
        arr.insert(10);
        arr.insert(1);
        arr.insert(2);
        arr.insert(9);
        arr.insert(8);
        arr.insert(15);
        arr.insert(0);
        arr.insert(3);
        arr.display();
        arr.insertSort();
        arr.display();
    }
}
