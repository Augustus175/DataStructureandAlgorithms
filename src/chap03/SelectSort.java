package chap03;

/**
 * Created by zhangzhibo on 17-3-2.
 * Page 64
 */
class SelectSort {
    private long[] a;
    private int nElems;

    public SelectSort(int max) {
        a = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }

    public void display() {
        for (int i = 0; i < nElems - 1; i++) {
            System.out.print(a[i] + " ");

        }
        System.out.println(a[nElems - 1]);
    }

    public void selectSort()
    {
        int out ;
        int in ;
        int min ;
        for ( out = 0; out <nElems ; out++) {
            min = out;
            for ( in = out+1; in <nElems ; in++) {
                if(a[min] > a[in])
                {
                    min = in;
                }

            }
            if(min != out)
            {
                long tmp = a[out];
                a[out] = a[min];
                a[min] = tmp;
            }

        }
    }
}
