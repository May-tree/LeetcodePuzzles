/**
 * Created by NicolasTsui on 7/11/15.
 */

import java.util.*;

public class ConcatenationOfWords {
    public static List<Integer> findSubstring(String S, String[] L) {
        List<Integer> res = new ArrayList<>();
        if (L.length == 0) {
            return res;
        }
        int len = L[0].length();
        int num = L.length;
        if (len * num > S.length()) {
            return res;
        }
        HashMap<String, Integer> dic = new HashMap<>();
        for (String s : L) {
            if (dic.containsKey(s)) {
                dic.put(s, dic.get(s) + 1);
            } else {
                dic.put(s, 1);
            }
        }
        String[] sDic = new String[S.length() - len + 1];
        for (int i = 0; i < sDic.length; i++) {
            String sub = S.substring(i, i + len);
            if (dic.containsKey(sub)) {
                sDic[i] = sub;
            } else {
                sDic[i] = "";
            }
        }

        for (int i = 0; i < len; i++) {
            HashMap<String, Integer> tempDic = new HashMap<>();
            int start = i;
            int found = 0;
            for (int j = i; j <= S.length() - len; j = j + len) {
                String word = sDic[j];
                if (word.equals("")) {
                    tempDic = new HashMap<>();
                    start = j + len;
                    found = 0;
                    continue;
                } else {
                    if (!tempDic.containsKey(word)) {
                        tempDic.put(word, 1);
                    } else {
                        tempDic.put(word, tempDic.get(word) + 1);
                    }
                    found++;
                }
                if (tempDic.get(word) > dic.get(word)) {
                    while (!sDic[start].equals(word)) {
                        tempDic.put(sDic[start], tempDic.get(sDic[start]) - 1);
                        start += len;
                        found--;
                    }
                    tempDic.put(sDic[start], tempDic.get(sDic[start]) - 1);
                    start += len;
                    found--;
                }
                if (found == num) {
                    res.add(start);
                }

            }

        }
        return res;
    }

    public static void main(String[] args) {
        String s = "barfoofoobarthefoobarman";
        String[] words = {"foo", "bar", "the"};
        List<Integer> list = findSubstring(s, words);
        for (int i : list) {
            System.out.println(i);
        }
    }
}
