package OctoberAlgorithms.chap02b;


/**
 * Created by zhangzhibo on 17-5-27.
 */
class tagSBacket {
    private boolean valid;
    private int min;
    private int max;

    public void add(int n) {
        if (!valid) {
            min = n;
            max = n;
            valid = true;
        } else {
            if (min > n) {
                min = n;
            } else if (max < n) {
                max = n;
            }
        }
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public boolean isValid() {
        return valid;
    }
}

public class MaxGapApp {
    public static void main(String[] args) {
        int[] a = {1, 7, 14, 9, 4, 13};
        int result = MaxGapA(a);
        System.out.println(result);
    }

    public static int MaxGapA(int[] a) {
        int size = a.length;
        int min = a[0];
        int max = a[0];
        tagSBacket[] baskets = new tagSBacket[size];
        for (int i = 0; i < size; i++) {
            baskets[i] = new tagSBacket();
        }
        for (int i = 0; i < size; i++) {
            if (min > a[i]) {
                min = a[i];
            } else if (max < a[i]) {
                max = a[i];
            }
        }

        int deta = max - min;
        int nBasket;
        for (int i = 0; i < size; i++) {
            nBasket = (a[i] - min) * size / deta;
            if (nBasket >= size) {
                nBasket = size - 1;
            }
            baskets[nBasket].add(a[i]);
        }

        int nGap = deta / size;
        int gap;
        int i = 0;
        for (int j = 1; j < size; j++) {
            if (baskets[j].isValid()) {
                gap = baskets[j].getMin() - baskets[i].getMax();
                if (nGap < gap) {
                    nGap = gap;
                }
                i = j;
            }
        }
        return nGap;
    }
}
