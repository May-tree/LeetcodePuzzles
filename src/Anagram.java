/**
 * Created by NicolasTsui on 7/19/15.
 */

import java.util.*;

public class Anagram {
    public List<String> anagrams(String[] strs) {
        List<String> list = new ArrayList<>();
        List<Integer> idx = new ArrayList<>();
        HashMap<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String temp = sd(strs[i]);
            if (map.containsKey(temp)) {
                map.get(temp).add(i);
            } else {
                List<Integer> newList = new ArrayList<>();
                newList.add(i);
                map.put(temp, newList);
            }
        }
        for (String str : map.keySet()) {
            if (map.get(str).size() > 1) {
                for (int i : map.get(str)) {
                    list.add(strs[i]);
                }
            }
        }
        return list;
    }

    public String sd(String s) {
        char[] ar = s.toCharArray();
        Arrays.sort(ar);
        return String.valueOf(ar);
    }
}
