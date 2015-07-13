/**
 * Created by NicolasTsui on 7/13/15.
 */
public class SearchRange {
    public static int[] searchRange(int[] A, int target) {
        int[] range={-1,-1};
        if(A.length==0 || target>A[A.length-1]||target<A[0]){
            return range;
        }
        searchRange(A,target,0,A.length-1,range);
        return range;
    }
    public static void searchRange(int[] A,int target, int start, int end, int[] range){
        if(start>end){
            return;
        }
        int mid=(start+end)/2;
        if(A[mid]==target){
            if(range[0]==-1||mid<range[0]){
                range[0]=mid;
                searchRange(A,target,start,mid-1,range);
            }
            if(range[1]==-1||mid>range[1]){
                range[1]=mid;
                searchRange(A,target,mid+1,end,range);
            }
        }
        else if(A[mid]>target){
            searchRange(A,target,start,mid-1,range);
        }
        else{
            searchRange(A,target,mid+1,end,range);
        }
    }
}
