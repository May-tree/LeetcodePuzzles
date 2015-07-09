package classicSortAlgorithms;

public class HeapSort {
    public static void buildMaxHeap(int[] arr){
        for(int i=(arr.length-1)/2;i>=0;i--){
            heapMaximize(arr, i, arr.length);
        }
    }
    public static void buildMinHeap(int[] arr){
        for(int i=(arr.length-1)/2;i>=0;i--){
            heapMinimize(arr, i, arr.length);
        }
    }
    public static void heapMinimize(int[] arr, int i, int size){
        int l=i*2+1;
        int r=i*2+2;
        int min_idx=i;
        if(l<size){
            min_idx=arr[i]<arr[l]?i:l;
        }
        if(r<size){
            min_idx=arr[min_idx]<arr[r]?min_idx:r;
        }
        if(min_idx!=i){
            swap(arr, i, min_idx);
            heapMinimize(arr, min_idx, size);
        }
    }
    public static void heapMaximize(int[] arr, int i, int size){
        int l=i*2+1;
        int r=i*2+2;
        int max_idx=i;
        if(l<size){
            max_idx=arr[i]>arr[l]?i:l;
        }
        if(r<size){
            max_idx=arr[max_idx]>arr[r]?max_idx:r;
        }
        if(max_idx!=i){
            swap(arr, i, max_idx);
            heapMaximize(arr, max_idx, size);
        }
    }
    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void heapSort(int[] arr){
        buildMaxHeap(arr);
        for(int i:arr){
            System.out.print(" "+i);
        }
        System.out.println();
        int size=arr.length;
        for(int i=arr.length-1;i>=0;i--){
            swap(arr,0,size-1);
            size--;
            heapMaximize(arr, 0, size);
        }
    }
    public static void main(String[] args){
        int[] arr={4,1,3,2,16,9,10,14,8,7};
        heapSort(arr);
        for(int i:arr){
            System.out.print(" "+i);
        }
    }
}
