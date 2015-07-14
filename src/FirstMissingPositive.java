/**
 * Created by NicolasTsui on 7/14/15.
 * counting sort
 * A[i]=i+1 (condition)
 */

public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        for(int i=0;i<A.length;i++){
            if(A[i]<=A.length && A[i]>0 && A[A[i]-1]!=A[i]){
                swap(A,i,A[i]-1);
                i--;
            }
        }
        for(int i=0;i<A.length;i++){
            if(A[i]!=i+1){
                return i+1;
            }
        }
        return A.length+1;
    }

    public void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
