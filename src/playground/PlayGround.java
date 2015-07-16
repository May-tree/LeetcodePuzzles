package playground;

import java.util.*;

/**
 * Created by NicolasTsui on 7/10/15.
 */
public class PlayGround {
    public static int[] deduplicate(int[] nums){
        HashSet<Integer> set=new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        int[] newnum=new int[set.size()];
        int j=0;
        for(int i:set){
            newnum[j]=i;
            j++;
        }
        return newnum;
    }
    public static int[][] vertical(int[][] arr){
        int row=arr.length;
        int col=arr[0].length;
        int[][] arr2=new int[row][col];
        for(int i=0;i<row/2;i++){
            for(int j=0;j<col;j++){
                arr2[i][j]=arr[row-1-i][j];
            }
        }
        if(row%2!=0){
            for(int j=0;j<col;j++){
                arr2[row/2+1][j]=arr[row/2+1][j];
            }
        }
        return arr2;
    }
    public static int[][] horizontal(int[][] arr){
        return new int[2][3];
    }

    public static void main(String[] args){
        String s="yo"+"0";
        System.out.println(s);
    }
}
