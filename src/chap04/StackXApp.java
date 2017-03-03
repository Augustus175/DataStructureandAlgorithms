package chap04;

/**
 * Created by zhangzhibo on 17-3-3.
 * Page 87
 */
public class StackXApp {
    public static void main(String[] args) {
        StackX theStack = new StackX(5);
        System.out.println(theStack.isEmpty());
        System.out.println(theStack.isFull());
//        System.out.println(theStack.peek());
        theStack.push(1);
        theStack.push(2);
        theStack.push(3);
        theStack.push(4);
        theStack.push(5);
//        theStack.push(6);
//        long tmp= 0;
//        System.out.println(theStack.pop());
        System.out.println(theStack.isFull());
//        System.out.println(theStack.peek());
        System.out.println(theStack.pop());
        System.out.println(theStack.pop());
        System.out.println(theStack.pop());
        System.out.println(theStack.pop());
        System.out.println(theStack.pop());


        System.out.println(theStack.isEmpty());
        System.out.println(theStack.isFull());

    }
}
