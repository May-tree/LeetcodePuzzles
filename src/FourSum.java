/**
 * Created by NicolasTsui on 7/9/15.
 */

import java.util.*;

public class FourSum {
    public static List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(num);
        for (int i = 0; i < num.length - 3; i++) {
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < num.length - 2; j++) {
                if (j > i + 1 && num[j] == num[j - 1]) {
                    continue;
                }
                int remain = target - num[i] - num[j];
                int start = j + 1;
                int end = num.length - 1;
                while (start < end) {
                    if (num[start] + num[end] == remain) {
                        List<Integer> list = new ArrayList<>();
                        list.add(num[i]);
                        list.add(num[j]);
                        list.add(num[start]);
                        list.add(num[end]);
                        lists.add(list);
                        start++;
                        end--;
                        while (start < end && num[start] == num[start - 1]) {
                            start++;
                        }
                        while (start < end && num[end] == num[end + 1]) {
                            end--;
                        }
                    } else if (num[start] + num[end] < remain) {
                        start++;
                        while (start < end && num[start] == num[start - 1]) {
                            start++;
                        }
                    } else {
                        end--;
                        while (start < end && num[end] == num[end + 1]) {
                            end--;
                        }
                    }
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        int[] num = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> lists = fourSum(num, 0);
        for (List<Integer> list : lists) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
