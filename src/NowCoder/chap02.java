package NowCoder;

/**
 * Created by Gavin.Stevenson on 2017/4/21.
 */
public class chap02 {
    public int[] selectionSort(int[] A, int n) {
        // write code here

        for(int i = 0;i< n;i++){
            int min = A[i];
            int k = i;
            for(int j = i+1;j<n;j++){
                if(min > A[j]){
                    min = A[j];
                    k = j;
                }
            }
            A[k] = A[i];
            A[i] = min;

        }
        return A;
    }
    public int[] insertionSort(int[] A, int n) {
        // write code here
        for(int i = 0;i<n;i++)
        {
            int tmp = A[i];
            int k = -1;
            for(int j = i-1; j>= 0;j--){
                if(tmp < A[j]){
                    A[j+1] = A[j];
                    A[j] = tmp;
                }else{

                    break;
                }
            }


        }
        return A;

    }
}
