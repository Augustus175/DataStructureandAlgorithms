package chap02;

/**
 * Created by zhangzhibo on 17-3-1.
 *Page36
 */
public class BinaryFind {
    public static void main(String[] args) {
        OrdArray arr = new OrdArray(10);
        arr.insert(21);
        arr.insert(10);
        arr.insert(31);
        arr.insert(41);
        arr.insert(29);
        arr.insert(11);
        arr.insert(0);
        arr.insert(91);
        arr.insert(1);
        arr.insert(7);
        arr.insert(3);
        arr.insert(111);
        arr.insert(20);
        arr.insert(5);
        arr.display();
        System.out.println(arr.find(29));
        arr.delete(31);
        arr.display();
        arr.insert(31);
        arr.display();

    }
}
