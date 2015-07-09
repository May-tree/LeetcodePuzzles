/**
 * Created by NicolasTsui on 7/9/15.
 */
import java.util.*;
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists=new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int remain=-nums[i];
            int start=i+1;
            int end=nums.length-1;
            while(start<end){
                if(nums[start]+nums[end]==remain){
                    List<Integer> list=new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    lists.add(list);
                    start++;
                    end--;
                    while(start<end && nums[start]==nums[start-1]){
                        start++;
                    }
                    while(start<end-1 && nums[end]==nums[end+1]){
                        end--;
                    }
                }
                else if(nums[start]+nums[end]<remain){
                    start++;
                    while(start<end && nums[start]==nums[start-1]){
                        start++;
                    }
                }
                else{
                    end--;
                    while(start<end && nums[end]==nums[end+1]){
                        end--;
                    }
                }

            }

        }
        return lists;
    }
}
