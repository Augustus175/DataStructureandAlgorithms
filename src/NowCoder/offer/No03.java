package NowCoder.offer;

/**
 * Created by zhangzhibo on 17-6-18.
 */
public class No03 {
    public static void main(String[] args) {
        int[][] array = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(Find(7, array));
    }

    public static boolean Find(int target, int[][] array) {
        if (array.length == 0) {
            return false;
        }
        int intres = 0;
        int low = 0;
        int up = array[0].length;
        int mid = 0;
        while (true) {
            mid = (up + low) / 2;

            if (target == array[0][mid]) {
                intres = mid;
                break;
            } else if (up - low == 1) {
                intres = low;
                break;
            } else if (target > array[0][mid]) {
                low = mid;
            } else {
                up = mid;
            }
        } low = 0;
        up = array.length;
        while (true) {
            mid = (low + up) / 2;
            if (target == array[mid][intres]) {
                return true;
            } else if (up < low) {
                return false;
            } else if (target > array[mid][intres]) {
                up = mid + 1;
            } else {
                low = mid - 1;
            }

        }
    }
}

