/**
 * Created by NicolasTsui on 7/10/15.
 */
public class RemoveDuplicateFromSortedArray {
    public static int removeDuplicates(int[] A) {
        if(A.length==0){
            return 0;
        }
        int i=0;
        for(int j=1;j<A.length;j++){
            if(A[i]!=A[j]){
                i++;
            }
            A[i]=A[j];
        }
        return i+1;
    }
}
