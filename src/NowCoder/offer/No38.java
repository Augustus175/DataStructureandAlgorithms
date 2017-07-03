package NowCoder.offer;

/**
 * Created by zhangzhibo on 17-7-3.
 */
public class No38 {
    public static void main(String[] args) {
//        int[] a = {1,2,3};
        int[] a = {364, 637, 341, 406, 747, 995, 234, 971, 571, 219, 993, 407, 416, 366, 315, 301, 601, 650, 418, 355, 460, 505, 360, 965, 516, 648, 727, 667, 465, 849, 455, 181, 486, 149, 588, 233, 144, 174, 557, 67, 746, 550, 474, 162, 268, 142, 463, 221, 882, 576, 604, 739, 288, 569, 256, 936, 275, 401, 497, 82, 935, 983, 583, 523, 697, 478, 147, 795, 380, 973, 958, 115, 773, 870, 259, 655, 446, 863, 735, 784, 3, 671, 433, 630, 425, 930, 64, 266, 235, 187, 284, 665, 874, 80, 45, 848, 38, 811, 267, 575};
        int result = mergeSort(a, 0, a.length - 1);
        System.out.println(result% 1000000007);
        for (int k :
                a) {
            System.out.print(k + " ");
        }
//        partition(a, 0, a.length - 1, 11);
    }

    public static int mergeArray(int[] a, int start, int mid, int end) {
        if (start == end) {
            return 0;
        }
        int i = mid;
        int j = end;
        int k = end - start;
        int count = 0;
        int[] tmp = new int[end - start + 1];
        while (i >= start && j > mid) {
            if (a[i] > a[j]) {
                count += j - mid;
                count = count % 1000000007;
                tmp[k--] = a[i--];
            } else {
                tmp[k--] = a[j--];
            }
        }
        while (i >= start) {
            tmp[k--] = a[i--];
        }
        while (j > mid) {
            tmp[k--] = a[j--];
        }
        for (int l = 0; l < tmp.length; l++) {
            a[l + start] = tmp[l];
        }
        return count;
    }

    public static int mergeSort(int[] a, int start, int end) {
        int leftcount = 0;
        int rightcount = 0;
        int count = 0;
        if (start < end) {
            int mid = (start + end) >> 1;
            leftcount = mergeSort(a, start, mid) % 1000000007;
            rightcount = mergeSort(a, mid + 1, end) % 1000000007;
            count = mergeArray(a, start, mid, end) % 1000000007;
        }
        return leftcount + rightcount + count;
    }
}
