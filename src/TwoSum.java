import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
    }
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (sumMap.containsKey(nums[i])) {
                result[0] = sumMap.get(nums[i]);
                result[1] = i + 1;
                return result;
            } else {
                sumMap.put(target - nums[i], i + 1);
            }
        }
        return result;
    }

}
