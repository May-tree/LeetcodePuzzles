/**
 * Created by NicolasTsui on 7/9/15.
 */

import java.util.*;

public class GenerateParenthese {
    public static List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        List<String> results = new ArrayList<>();
        char[] charSet = {'(', ')'};
        DFS(results, sb, charSet, n, 1, 0);
        return results;
    }

    public static void DFS(List<String> results, StringBuilder sb, char[] charSet, int n, int l, int r) {
        if (l == n && r == n) {
            results.add(sb.toString());
        } else {
            for (char c:charSet) {
                if (l == n && c == '(') {
                    continue;
                }
                if (l == r && c == ')') {
                    continue;
                }
                sb.append(c);
                if (c == '(') {
                    l++;
                } else {
                    r++;
                }
                DFS(results, sb, charSet, n, l, r);
                char d = sb.charAt(sb.length() - 1);
                sb.deleteCharAt(sb.length() - 1);
                if (d == '(') {
                    l--;
                } else {
                    r--;
                }
            }
        }
    }
}
