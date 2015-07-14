/**
 * Created by NicolasTsui on 7/14/15.
 */
import java.util.*;
public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results=new ArrayList<>();
        List<Integer> result=new ArrayList<>();
        int[] newCand=deduplicate(candidates);
        findCombination(results,newCand,target,result);
        return results;
    }
    public static void findCombination(List<List<Integer>> results,int[] candidates, int target,List<Integer> result){
        if(target==0){
            results.add(deepCopy(result));
            return;
        }
        if(target<0){
            return;
        }
        for(int i=0;i<candidates.length;i++){
            if(i>0 && candidates[i]==candidates[i-1]){
                continue;
            }
            if(result.size()>0 && candidates[i]<result.get(result.size()-1)){
                continue;
            }
            result.add(candidates[i]);
            findCombination(results,candidates,target-candidates[i],result);
            result.remove(result.size()-1);
        }
    }
    public static List<Integer> deepCopy(List<Integer> result){
        List<Integer> copy=new ArrayList<>();
        for(int i:result){
            copy.add(i);
        }
        return copy;

    }
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
        int[] candidates={2,2,3};
        List<List<Integer>> results=combinationSum(candidates,7);
        System.out.println("hey");
    }
}
