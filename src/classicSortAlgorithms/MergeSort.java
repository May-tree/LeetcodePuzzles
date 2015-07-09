package classicSortAlgorithms;

import java.util.Arrays;
public class MergeSort {
    public static int[] merge(int[] arr1,int[] arr2){
        int[] arr3=new int[arr1.length+arr2.length];
        int i=0,j=0,k=0;
        while(i<arr1.length&&j<arr2.length){
            if(arr1[i]<arr2[j]){
                arr3[k]=arr1[i];
                i++;
            }
            else{
                arr3[k]=arr2[j];
                j++;
            }
            k++;
        }
        while(i<arr1.length){
            arr3[k]=arr1[i];
            k++;
            i++;
        }
        while(j<arr2.length){
            arr3[k]=arr2[j];
            k++;
            j++;
        }
        return arr3;
    }
    public static int[] mergeSort(int[] arr){
        if(arr.length==1){
            return arr;
        }else{
            int[] arr1=mergeSort(Arrays.copyOfRange(arr, 0, arr.length / 2));
            int[] arr2=mergeSort(Arrays.copyOfRange(arr,arr.length/2,arr.length));
            return merge(arr1,arr2);
        }
    }
    public static void main(String[] args){
        int[] arr1={7,5,1,1,1,1,3};
        arr1=mergeSort(arr1);
        for(int i:arr1){
            System.out.print(" "+i);
        }
    }
}
