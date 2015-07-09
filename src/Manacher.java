/**
 * Created by Mingyuan Cui on 7/8/15.
 */
public class Manacher {
    public static String standardise(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append('#');
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append('#');
        }
        return sb.toString();
    }

    public static String longest_pali(String s) {
        s = standardise(s);
        int[] p = new int[s.length()];
        for (int i = 0; i < p.length; i++) {
            p[i] = 0;
        }
        int mx = 0;
        int id = 0;
        for (int i = 0; i < s.length(); i++) {
            p[i] = mx - i > 0 ? Math.min(p[2 * id - i], mx - i) : 1;
            while (i - p[i] >= 0 && i + p[i] < s.length() && s.charAt(i + p[i]) == s.charAt(i - p[i])) {
                p[i]++;
            }
            if (p[i] + i > mx) {
                mx = p[i] + i;
                id = i;
            }
        }
        int max_p = -1;
        int position = -1;
        for (int i = 0; i < p.length; i++) {
            if (p[i] > max_p) {
                max_p = p[i];
                position = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = position - max_p + 2; i <= position + max_p - 2; i = i + 2) {
            sb.append(s.charAt(i));
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(longest_pali("12321234321"));
    }
}
