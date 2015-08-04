package aces;

/**
 * Created by NicolasTsui on 7/10/15.
 */
public class Kmp_findSubString {
    public static int[] get_next(String pattern) {
        int[] next = new int[pattern.length()];
        next[0] = -1;
        int j = 0;
        int k = -1;
        while (j < pattern.length() - 1) {
            if (k == -1 || pattern.charAt(k) == pattern.charAt(j)) {
                k++;
                j++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

    public static int match(String str, String pattern) {
        int[] next = get_next(pattern);
        int i = 0, j = 0;
        while (i < str.length() && j < pattern.length()) {
            if (j == -1 || str.charAt(i) == pattern.charAt(j)) {
                j++;
                i++;
            } else {
                j = next[j];
            }
        }
        if (j == pattern.length()) {
            return i - j;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int a=1;

        String str = "ABEDEABEFABEF";
        String pattern = "ABEF";
        System.out.println(match(str, pattern));
    }
}
