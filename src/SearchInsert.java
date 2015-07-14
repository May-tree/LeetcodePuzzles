/**
 * Created by NicolasTsui on 7/13/15.
 */
public class SearchInsert {
    public static int searchInsert(int[] A, int target) {
        if(A.length==0){
            return 0;
        }
        int i=0,j=A.length-1;
        while(i<j-1){
            int mid=(i+j)/2;
            if(A[mid]==target){
                return mid;
            }
            else if(A[mid]>target){
                j=mid-1;
            }
            else{
                i=mid+1;
            }
        }
        if(target<=A[i]){
            return i;
        }
        if(target==A[j]){
            return j;
        }
        if(target>A[j]){
            return j+1;
        }
        return j;
    }
}
