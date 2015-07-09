/**
 * Created by NicolasTsui on 7/9/15.
 */
import java.util.*;
public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min=nums[0]+nums[1]+nums[2]-target;
        for(int i=0;i<nums.length-2;i++){
            int start=i+1;
            int end=nums.length-1;
            while(start<end){
                int sum=nums[start]+nums[end]+nums[i];
                int dif=sum-target;
                if(sum==target){
                    return sum;
                }
                if(dif*dif<min*min){
                    min=dif;
                }
                if(sum>target){
                    end--;
                    while(start<end && nums[end]==nums[end+1]){
                        end--;
                    }
                }
                else{
                    start++;
                    while(start<end && nums[start]==nums[start-1]){
                        start++;
                    }
                }
            }

        }
        return target+min;
    }
    public static void main(String[] args){
        int[] nums={1,2,4,8,16,32,64,128};
        System.out.println(threeSumClosest(nums,82));
    }
}
