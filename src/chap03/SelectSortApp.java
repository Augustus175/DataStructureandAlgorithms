package chap03;

/**
 * Created by zhangzhibo on 17-3-2.
 *  Page 64
 */
public class SelectSortApp {
    public static void main(String[] args) {
        SelectSort arr = new SelectSort(10);
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
        arr.selectSort();
        arr.display();
    }
}
