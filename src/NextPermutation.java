/**
 * Created by NicolasTsui on 7/12/15.
 */
public class NextPermutation {
    public static void nextPermutation(int[] num) {
        if (num.length < 2) {
            return;
        }
        int tail = num.length - 1;
        while (tail > 0 && num[tail - 1] >= num[tail]) {
            tail--;
        }
        if (tail == 0) {
            reverse(num, 0, num.length - 1);
            return;
        } else {
            int k = tail - 1;
            int nextLarger = firstLarger(num, tail, num.length-1,num[k]);
            swap(num, k, nextLarger);
            reverse(num, tail, num.length - 1);
            return;
        }
    }

    public static void reverse(int[] num, int i, int j) {
        for (int k = i; k <= (j + i) / 2; k++) {
            swap(num, k, j + i - k);
        }
    }

    public static void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    public static int firstLarger(int[] num, int start, int end, int k) {
        if (end-start+1 == 1) {
            return start;
        }
        int i = start, j = end;
        while (i < j) {
            int mid = (i + j) / 2;
            if (num[mid] == k) {
                while (num[mid] == k) {
                    mid--;
                }
                return mid;
            } else if (num[mid] > k) {
                if (num[mid + 1] <= k) {
                    return mid;
                } else {
                    i = mid + 1;
                }
            } else {
                j = mid - 1;
            }
        }
        return i;

    }

    public static void main(String[] args) {
        int[] num = {3,1,4,4,2,3,4,0,0};
        nextPermutation(num);
        for (int i : num) {
            System.out.print(i);
        }
    }
}
