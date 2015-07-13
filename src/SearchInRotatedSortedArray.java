/**
 * Created by NicolasTsui on 7/13/15.
 */
public class SearchInRotatedSortedArray {
    public static int search(int[] A, int target) {
        if (A.length == 0) {
            return -1;
        }
        int i = 0, j = A.length - 1;
        while (i < j - 1) {
            int mid = (i + j) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] > target) {
                if(A[mid]>=A[i]){
                    if(A[i]==target){
                        return i;
                    }
                    else if(A[i]>target){
                        i=mid;
                    }
                    else{
                        j=mid;
                    }
                }else{
                    j=mid;
                }

            } else {
                if(A[mid]>=A[i]){
                    i=mid;
                }else{
                    if(A[j]==target){
                        return j;
                    }
                    else if(A[j]<target){
                        j=mid;
                    }else{
                        i=mid;
                    }
                }
            }
        }
        if (A[i] == target) {
            return i;
        } else if (A[j] == target) {
            return j;
        } else {
            return -1;
        }
    }
    public static void main(String[] args){
        int[] num={4,5,6,7,1,2,3};
        System.out.println(search(num,7));
    }
}
