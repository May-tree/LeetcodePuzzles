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
    public static void main(String[] args){
        int[] num={3,2,2,1,5,7,3,6,6};
        int[] newnum=deduplicate(num);
        for(int i:newnum){
            System.out.println(i);
        }
    }
}
