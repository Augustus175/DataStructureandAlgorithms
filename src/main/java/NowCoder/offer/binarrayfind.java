package NowCoder.offer;

/**
 * Created by zhangzhibo on 17-6-19.
 */
public class binarrayfind {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 9, 10, 13};
        System.out.println(find(a, 13));
        System.out.println(find(a, 19));
    }

    public static int find(int[] args, int key) {
        int start = 0;
        int end = args.length-1;
        int mid = 0;
        while(true){
            mid = (start+end)/2;
            if (args[mid]==key){
                return mid;
            }else if (start>end){
                return -1;
            }else if(args[mid]>key){
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
    }
}
