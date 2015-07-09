/**
 * Created by Mingyuan Cui on 7/8/15.
 */
import java.util.*;
public class FindKthFromSortedArrays {
    public static int findKth(int[] arr1, int[] arr2, int k) {
        if(arr1.length==0){
            return arr2[k-1];
        }
        if(arr2.length==0){
            return arr1[k-1];
        }
        if(k<=1){
            return Math.min(arr1[0],arr2[0]);
        }
        int h1=arr1.length/2;
        int h2=arr2.length/2;

        if(h1+h2+1<k){
            if(arr1[h1]<arr2[h2]){
                return findKth(Arrays.copyOfRange(arr1,h1+1,arr1.length),arr2,k-h1-1);
            }
            else{
                return findKth(arr1,Arrays.copyOfRange(arr2,h2+1,arr2.length),k-h2-1);
            }
        }
        else{
            if(arr1[h1]<arr2[h2]){
                return findKth(arr1,Arrays.copyOfRange(arr2,0,h2),k);
            }
            else{
                return findKth(Arrays.copyOfRange(arr1,0,h1),arr2,k);
            }
        }
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1=nums1.length;
        int len2=nums2.length;
        if((len1+len2)%2==0){
            int r1=findKth(nums1,nums2,(len1+len2)/2);
            int r2=findKth(nums1,nums2,(len1+len2)/2+1);
            System.out.println(r1+" "+r2);
            return (double)(r1+r2)/2;
        }
        else{
            return (double)(findKth(nums1,nums2,(len1+len2)/2+1));
        }
    }
    public static void main(String[] args){
        int[] a={};
        int[] b={2,3};
        System.out.println(findMedianSortedArrays(a,b));
    }
}
