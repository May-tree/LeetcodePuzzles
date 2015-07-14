import java.util.*;

/**
 * Created by NicolasTsui on 7/14/15.
 */
public class CombinationSumII {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results=new ArrayList<>();
        List<Integer> result=new ArrayList<>();
        Arrays.sort(candidates);
        findCombination(results,candidates,target,result,-1);
        return results;
    }
    public static void findCombination(List<List<Integer>> results,int[] candidates, int target,List<Integer> result,int last){
        if(target==0){
            results.add(deepCopy(result));
            return;
        }
        if(target<0){
            return;
        }
        for(int i=last+1;i<candidates.length;i++){
            if(i>last+1 && candidates[i-1]==candidates[i]){
                continue;
            }
            result.add(candidates[i]);
            findCombination(results,candidates,target-candidates[i],result,i);
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
    public static void main(String[] args){
        int[] candidates={1,1};
        List<List<Integer>> results=combinationSum2(candidates,2);
        System.out.println("hey");
    }
}
