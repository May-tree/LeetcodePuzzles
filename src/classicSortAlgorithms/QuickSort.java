package classicSortAlgorithms;

public class QuickSort {
    public static void quickSort(int[] arr,int p,int r){
        if(p<r){
            int q=partition(arr,p,r);
            quickSort(arr,p,q-1);
            quickSort(arr,q+1,r);
        }
    }
    public static int partition(int[] arr,int p,int r){
        int i=p-1;
        int prime=arr[r];
        for(int j=p;j<r;j++){
            if(arr[j]<=prime){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,r);
        return i+1;
    }
    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void main(String[] args){
        int[] arr={1,5,3,2,6,1};
        quickSort(arr,0,arr.length-1);
        for(int i:arr){
            System.out.print(" "+i);
        }
    }
}
