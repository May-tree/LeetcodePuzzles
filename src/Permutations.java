/**
 * Created by NicolasTsui on 7/16/15.
 */

import java.util.*;

public class Permutations {
    public List<List<Integer>> permute(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> lists = new ArrayList<>();
        boolean[] visited = new boolean[num.length];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        List<Integer> tempList = new ArrayList<>();
        find(num, visited, lists, tempList);
        return lists;
    }

    public void find(int[] num, boolean[] visited, List<List<Integer>> lists, List<Integer> tempList) {
        if (tempList.size() == num.length) {
            List<Integer> copy = deepCopy(tempList);
            lists.add(copy);
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (visited[i] || (i > 0 && num[i] == num[i - 1])) {
                continue;
            }
            tempList.add(num[i]);
            visited[i] = true;
            find(num, visited, lists, tempList);
            visited[i] = false;
            tempList.remove(tempList.size() - 1);
        }
        return;
    }

    public List<Integer> deepCopy(List<Integer> tempList) {
        List<Integer> copy = new ArrayList<>();
        for (int i = 0; i < tempList.size(); i++) {
            copy.add(tempList.get(i));
        }
        return copy;

    }
}
