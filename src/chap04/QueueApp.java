package chap04;

/**
 * Created by zhangzhibo on 17-3-6.
 */
public class QueueApp {
    public static void main(String[] args) {
        Queue theQueue = new Queue(10);
       int i = 0;
        while(!theQueue.isFull())
       {
           theQueue.insert(i);
           i++;
       }
        System.out.println("========================");
        System.out.println(theQueue.remove());
        System.out.println(theQueue.remove());
        System.out.println(theQueue.remove());
        System.out.println("========================");

        while(!theQueue.isFull())
        {
            theQueue.insert(i);
            i++;
        }
        while(!theQueue.isEmpty())
        {
            System.out.println(theQueue.remove());
        }



    }
}
